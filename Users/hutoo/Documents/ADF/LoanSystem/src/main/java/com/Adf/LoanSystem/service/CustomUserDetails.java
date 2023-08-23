package com.Adf.LoanSystem.service;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class CustomUserDetails implements UserDetails {

    private Integer nid;
    private String password;
    private String fname;
    private String lname;
    private String phone;
    private Collection<? extends GrantedAuthority> authorities;

    public CustomUserDetails(Integer nid, String password, String fname, String lname, String phone, Collection<? extends GrantedAuthority> authorities) {
        this.nid = nid;
        this.password = password;
        this.fname = fname;
        this.lname = lname;
        this.phone = phone;
        this.authorities = authorities;
    }
    public String getFname(){
        return fname;
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return nid.toString();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
