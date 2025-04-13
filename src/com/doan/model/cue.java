package com.doan.model;

public class cue {
    private String cue_id;
    private String cue_name;
    private double cue_price;
    private int cue_quantity;
    private boolean is_delete;

    public cue(String cue_id, String cue_name, double cue_price, int cue_quantity, boolean is_delete) {
        this.cue_id = cue_id;
        this.cue_name = cue_name;
        this.cue_price = cue_price;
        this.cue_quantity = cue_quantity;
        this.is_delete = is_delete;
    }

    public cue() {
    }

    public String getCue_id() {
        return cue_id;
    }

    public void setCue_id(String cue_id) {
        this.cue_id = cue_id;
    }

    public String getCue_name() {
        return cue_name;
    }

    public void setCue_name(String cue_name) {
        this.cue_name = cue_name;
    }

    public double getCue_price() {
        return cue_price;
    }

    public void setCue_price(double cue_price) {
        this.cue_price = cue_price;
    }

    public boolean isIs_delete() {
        return is_delete;
    }

    public void setIs_delete(boolean is_delete) {
        this.is_delete = is_delete;
    }



    public int getCue_quantity() {
        return cue_quantity;
    }



    public void setCue_quantity(int cue_quantity) {
        this.cue_quantity = cue_quantity;
    }
}
