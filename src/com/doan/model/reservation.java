/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.doan.model;

import java.time.LocalDateTime;

/**
 *
 * @author Asus
 */
public class reservation {
    private String res_id;
    private String cus_id;
    private String tab_id;
    private String emp_id;
    private LocalDateTime start_time;
    private String status;

    public reservation() {
    }

    public reservation(String res_id, String cus_id, String tab_id, String emp_id, LocalDateTime start_time, String status) {
        this.res_id = res_id;
        this.cus_id = cus_id;
        this.tab_id = tab_id;
        this.emp_id = emp_id;
        this.start_time = start_time;
        this.status = status;
    }

    public String getRes_id() {
        return res_id;
    }

    public void setRes_id(String res_id) {
        this.res_id = res_id;
    }

    public String getCus_id() {
        return cus_id;
    }

    public void setCus_id(String cus_id) {
        this.cus_id = cus_id;
    }

    public String getTab_id() {
        return tab_id;
    }

    public void setTab_id(String tab_id) {
        this.tab_id = tab_id;
    }

    public String getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(String emp_id) {
        this.emp_id = emp_id;
    }

    public LocalDateTime getStart_time() {
        return start_time;
    }

    public void setStart_time(LocalDateTime start_time) {
        this.start_time = start_time;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
