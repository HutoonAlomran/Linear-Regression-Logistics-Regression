package com.Adf.LoanSystem.dto;

public class UserDto {

    private Integer nid; // User's National ID
    private String fname; // User's first name

    private String lname; // User's last name

    private String phone; // User's phone number

    private String password; // User's password

    public UserDto() {
    }

    public UserDto(Integer nid, String fname, String lname, String phone, String password) {
        this.nid = nid;
        this.fname = fname;
        this.lname = lname;
        this.phone = phone;
        this.password = password;
    }

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
}
