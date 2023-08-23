package com.Adf.LoanSystem.controller;

import com.Adf.LoanSystem.dto.UserDto;
import com.Adf.LoanSystem.model.Loan;
import com.Adf.LoanSystem.model.User;
import com.Adf.LoanSystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.security.Principal;

@Controller
public class AdfLoanSystemController {
    @Autowired
    private UserDetailsService userDetailsService;
    private UserService userService;

    public AdfLoanSystemController(UserService userService) {
        this.userService = userService;
    }

    // Handle the initial request for the homepage
    @GetMapping("/")
    public String index(){
        return "SignIn"; // Return the "SignIn" view
    }

    // Handle the request to show the sign-up page
    @GetMapping("/SignUp")
    public String showSignUpForm(Model model, UserDto userDto){
        model.addAttribute("user", userDto);
        return "SignUp"; // Return the "SignUp" view
    }

    // Handle the request to show the sign-in page
    @GetMapping("/SignIn")
    public String showSignInForm(Model model, UserDto userDto){
        model.addAttribute("user", userDto);
        return "SignIn"; // Return the "SignIn" view
    }

    // Handle the request to show loan details
    @GetMapping("/loanDetails")
    public String showLoanDetails(Model model, Principal principal){
        //UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getFname());
        //model.addAttribute("userdetail", userDetails);
        return "loandetails"; // Return the "loandetails" view
    }


    // Handle the request to show the loan request form
    @GetMapping("/loanRequest")
    public String showLoanRequest(){
        return "loanRequest"; // Return the "loanRequest" view
    }

    // Handle user SignUp form submission
    @PostMapping("/SignUp")
    public String SignUpSave(@ModelAttribute("user") UserDto userDto, Model model){
        User user = userService.findByNid(userDto.getNid());
        if (user != null) {
            model.addAttribute("userexist", user);
            return "SignUp";

        }
        userService.save(userDto);
        return "redirect:/SignUp?SignUpSuccess"; // Return the "SignIn" view
    }

    // Handle the loan Request form submission
    @PostMapping("/loanRequest")
    public String loanRequest(@ModelAttribute Loan loan) {
        System.out.println(loan.toString()); // Print loan information for debugging
        return "loandetails"; // Return the "loandetails" view
    }

    // Global exception handler for handling unexpected exceptions
    @ControllerAdvice
    public class GlobalExceptionHandler {

        @ExceptionHandler(Exception.class)
        public String handleException(Exception e) {
            e.printStackTrace();
            return "error"; // Return an error page
        }
    }
}
