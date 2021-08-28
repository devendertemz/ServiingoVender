package com.webmingo.serviingovendors.storage;

public class User_login {
    int loginid;
    private String id;
    private String fullname;
    private String phone;
    private String email;
    private String role;
    private String access_token;


    public User_login(int loginid, String id, String fullname, String phone, String email, String role, String access_token) {
        this.loginid = loginid;
        this.id = id;
        this.fullname = fullname;
        this.phone = phone;
        this.email = email;
        this.role = role;
        this.access_token = access_token;
    }

    public int getLoginid() {
        return loginid;
    }

    public void setLoginid(int loginid) {
        this.loginid = loginid;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }
}


