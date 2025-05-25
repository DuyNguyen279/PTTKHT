/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.doan.control;

import com.doan.dao.CueDAO;
import com.doan.dao.billiardTableDAO;
import com.doan.model.billiard_table;
import com.doan.model.cue;
import com.doan.model.customer;
import com.doan.model.item;

/**
 *
 * @author Asus
 */
public class edit {
    public static edit getInstance() {
        return new edit();
    }

    public void editBilliardTable(String id, String name, Double price, String type) {
        billiard_table table = new billiardTableDAO().getInstance().selectById(id);
        table.setTab_name(name);
        table.setTab_price(price);
        table.setTab_type(type);
        new billiardTableDAO().getInstance().update(table);
    }

    public void editCue(String id, String name, Double price, int quantity) {
        cue c = new cue(id, name, price, quantity, false);
        new CueDAO().getInstance().update(c);
    }

    public void editItem(String id, String name, int quantity, Double price) {
        item item = new com.doan.model.item(id, name, quantity, price, false);
        new com.doan.dao.ItemDAO().getInstance().update(item);
    }

    public void editCustomer(String id, String name, String phone) {
        customer c = new com.doan.model.customer(id, name, phone, 0, false);
        new com.doan.dao.customerDAO().getInstance().update(c);
    }
}
