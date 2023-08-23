package com.Adf.LoanSystem.service;

import com.Adf.LoanSystem.model.User;
import com.Adf.LoanSystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    /*
    @Autowired
    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }*/

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Integer nid;
        if (username != null && !username.isEmpty()) {
            nid = Integer.parseInt(username);
        } else {
            // Handle the case when the username is empty or null
            throw new UsernameNotFoundException("Username is empty or null");
        }
        User user = userRepository.findByNid(nid);

        if (user == null){
            throw new UsernameNotFoundException("Username or password not found");

        }

        return new CustomUserDetails(
                user.getNid(),
                user.getPassword(),
                user.getFname(),
                user.getLname(),
                user.getPhone(),
                authorities()
                );
    }



    public Collection<? extends GrantedAuthority> authorities () {
        return Arrays.asList(new SimpleGrantedAuthority("USER"));
    }
}
