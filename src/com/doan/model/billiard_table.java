package com.doan.model;

import java.time.LocalDateTime;

public class billiard_table {
    private String tab_id;
    private String tab_name;
    private LocalDateTime start;
    private LocalDateTime end;
    private Double tab_price;
    private String tab_type;
    private String status;
    private boolean is_delete;
    
    public billiard_table() {
    }

    public billiard_table(String tab_id, String tab_name, LocalDateTime start, LocalDateTime end, Double tab_price, String tab_type, String status, boolean is_delete) {
        this.tab_id = tab_id;
        this.tab_name = tab_name;
        this.start = start;
        this.end = end;
        this.tab_price = tab_price;
        this.tab_type = tab_type;
        this.status = status;
        this.is_delete = is_delete;
    }

    public String getTab_id() {
        return tab_id;
    }

    public void setTab_id(String tab_id) {
        this.tab_id = tab_id;
    }

    public String getTab_name() {
        return tab_name;
    }

    public void setTab_name(String tab_name) {
        this.tab_name = tab_name;
    }

    public LocalDateTime getStart() {
        return start;
    }

    public void setStart(LocalDateTime start) {
        this.start = start;
    }

    public LocalDateTime getEnd() {
        return end;
    }

    public void setEnd(LocalDateTime end) {
        this.end = end;
    }

    public Double getTab_price() {
        return tab_price;
    }

    public void setTab_price(Double tab_price) {
        this.tab_price = tab_price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean isIs_delete() {
        return is_delete;
    }

    public void setIs_delete(boolean is_delete) {
        this.is_delete = is_delete;
    }

    public String getTab_type() {
        return tab_type;
    }

    public void setTab_type(String tab_type) {
        this.tab_type = tab_type;
    }

    
}
