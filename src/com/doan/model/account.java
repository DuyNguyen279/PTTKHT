package com.doan.model;

public class account {
    private String acc_id;
    private String acc_name;
    private String username;
    private String password;
    private boolean  status;
    private String role;

    public account(String acc_id, String acc_name, String username, String password, boolean status, String role) {
        this.acc_id = acc_id;
        this.acc_name = acc_name;
        this.username = username;
        this.password = password;
        this.status = status;
        this.role = role;
    }

    public account() {
    }
    
    public String getAcc_id() {
        return acc_id;
    }
    public void setAcc_id(String acc_id) {
        this.acc_id = acc_id;
    }
    public String getAcc_name() {
        return acc_name;
    }
    public void setAcc_name(String acc_name) {
        this.acc_name = acc_name;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public boolean  getStatus() {
        return status;
    }
    public void setStatus(boolean  status) {
        this.status = status;
    }
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }

    

}
