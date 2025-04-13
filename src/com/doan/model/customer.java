package com.doan.model;

public class customer {
    private String cus_id;
    private String cus_name;
    private String cus_phone;
    private int point;
    private boolean is_delete;

    public customer(String cus_id, String cus_name, String cus_phone, int point, boolean is_delete) {
        this.cus_id = cus_id;
        this.cus_name = cus_name;
        this.cus_phone = cus_phone;
        this.point = point;
        this.is_delete = is_delete;
    }

    public customer() {
    }
    
    public String getCus_id() {
        return cus_id;
    }
    public void setCus_id(String cus_id) {
        this.cus_id = cus_id;
    }
    public String getCus_name() {
        return cus_name;
    }
    public void setCus_name(String cus_name) {
        this.cus_name = cus_name;
    }
    public String getCus_phone() {
        return cus_phone;
    }
    public void setCus_phone(String cus_phone) {
        this.cus_phone = cus_phone;
    }
    public int getPoint() {
        return point;
    }
    public void setPoint(int point) {
        this.point = point;
    }
    public boolean isIs_delete() {
        return is_delete;
    }
    public void setIs_delete(boolean is_delete) {
        this.is_delete = is_delete;
    }

    
}
