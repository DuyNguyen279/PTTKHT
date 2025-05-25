package com.doan.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class bill {
    private String bill_id;
    private LocalDateTime created_at;
    private double total;
    private List<item> items;
    private List<cue> cues;
    private String emp_id;
    private String tab_id;
    private String cus_id;
    private boolean is_done;

    public bill(String bill_id, LocalDateTime created_at, double total, List<item> items, List<cue> cues, String emp_id, String tab_id, String cus_id, boolean is_done) {
        this.bill_id = bill_id;
        this.created_at = created_at;
        this.total = total;
        this.items = items;
        this.cues = cues;
        this.emp_id = emp_id;
        this.tab_id = tab_id;
        this.cus_id = cus_id;
        this.is_done = is_done;
    }

    public bill() {
        items = new ArrayList<>();
        cues = new ArrayList<>();
    }

    public String getBill_id() {
        return bill_id;
    }

    public void setBill_id(String bill_id) {
        this.bill_id = bill_id;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public List<item> getItems() {
        return items;
    }

    public void setItems(List<item> items) {
        if (this.items == null) {
            this.items = new ArrayList<>();
        }
        this.items = items;
    }

    public List<cue> getCues() {
        if (this.cues == null) {
            this.cues = new ArrayList<>();
        }
        return cues;
    }

    public void setCues(List<cue> cues) {
        this.cues = cues;
    }

    public String getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(String emp_id) {
        this.emp_id = emp_id;
    }

    public String getTab_id() {
        return tab_id;
    }

    public void setTab_id(String tab_id) {
        this.tab_id = tab_id;
    }

    public String getCus_id() {
        return cus_id;
    }

    public void setCus_id(String cus_id) {
        this.cus_id = cus_id;
    }

    public boolean isIs_done() {
        return is_done;
    }

    public void setIs_done(boolean is_done) {
        this.is_done = is_done;
    }

}
