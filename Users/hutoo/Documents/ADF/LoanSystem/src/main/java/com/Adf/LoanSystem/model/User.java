package com.Adf.LoanSystem.model;

import java.util.List;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "User")
@Data // Lombok annotation to generate getter, setter, toString, and other methods
public class User {
    @Id
    @Column(name="nid")
    private Integer nid; // User's National ID

    @Column(name="fname")
    private String fname; // User's first name

    @Column(name="lname")
    private String lname; // User's last name

    @Column(name="phone")
    private String phone; // User's phone number

    @Column(name="password")
    private String password; // User's password

    // Default constructor
    public User() {
    }

    // Constructor to initialize user attributes
    public User(Integer nid, String fname, String lname, String phone, String password) {
        this.nid = nid;
        this.fname = fname;
        this.lname = lname;
        this.phone = phone;
        this.password = password;
    }

    // Getter and setter methods for various attributes
    public Integer getNid() {
        return nid;
    }

    public void setNid(Integer nid) {
        this.nid = nid;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "nid=" + nid +
                ", fname='" + fname + '\'' +
                ", lname='" + lname + '\'' +
                ", phone='" + phone + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
