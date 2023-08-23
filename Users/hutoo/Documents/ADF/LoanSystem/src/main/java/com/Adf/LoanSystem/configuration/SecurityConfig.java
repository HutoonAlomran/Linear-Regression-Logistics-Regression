package com.Adf.LoanSystem.configuration;

import com.Adf.LoanSystem.service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Autowired
    CustomUserDetailsService customUserDetailsServices;

    @Bean
    public static PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @SuppressWarnings("removal")
    @Bean

    public SecurityFilterChain securityFilterChain(HttpSecurity http)throws Exception {

        http.csrf().disable()
                .authorizeHttpRequests()
                .requestMatchers("/css/**", "/fonts/**", "/images/**", "/js/**", "/vendor/jquery/**").permitAll()
                .requestMatchers("/SignUp", "/SignIn", "/loanDetails").permitAll() // Add /loanDetails
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .usernameParameter("nid")
                .passwordParameter("password")
                .loginPage("/SignIn")
                .loginProcessingUrl("/SignIn")
                .defaultSuccessUrl("/loanDetails", true)
                .permitAll()
                .and()
                .logout()
                .invalidateHttpSession(true)
                .clearAuthentication(true)
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/SignIn?logout")
                .permitAll();

        return http.build();

    }


    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(customUserDetailsServices).passwordEncoder(passwordEncoder());
    }
}
