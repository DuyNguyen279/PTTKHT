package com.doan.model;

public class employee {
    private String emp_id;
    private String emp_name;
    private String emp_phone;
    private String email;
    private boolean is_delete;
    private String acc_id;

    public employee(String emp_id, String emp_name, String emp_phone, String email, boolean is_delete, String acc_id) {
        this.emp_id = emp_id;
        this.emp_name = emp_name;
        this.emp_phone = emp_phone;
        this.email = email;
        this.is_delete = is_delete;
        this.acc_id = acc_id;
    }

    public employee() {
    }

    public String getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(String emp_id) {
        this.emp_id = emp_id;
    }

    public String getEmp_name() {
        return emp_name;
    }

    public void setEmp_name(String emp_name) {
        this.emp_name = emp_name;
    }

    public String getEmp_phone() {
        return emp_phone;
    }

    public void setEmp_phone(String emp_phone) {
        this.emp_phone = emp_phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isIs_delete() {
        return is_delete;
    }

    public void setIs_delete(boolean is_delete) {
        this.is_delete = is_delete;
    }

    public String getAcc_id() {
        return acc_id;
    }

    public void setAcc_id(String acc_id) {
        this.acc_id = acc_id;
    }
}
