/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.doan.control;

import com.doan.dao.CueDAO;
import com.doan.dao.ItemDAO;
import com.doan.dao.billiardTableDAO;
import com.doan.dao.customerDAO;
import com.doan.model.billiard_table;
import com.doan.model.cue;
import com.doan.model.customer;
import com.doan.model.item;

/**
 *
 * @author Asus
 */
public class addNew {
    public static addNew getInstance() {
        return new addNew();
    }

    public void addNewBilliardTable(String id, String name, Double price, String type){
        billiard_table table = new billiard_table(id, name, null, null, price,type, "Trống", false);
        new billiardTableDAO().getInstance().insert(table);
    }

    public void addNewCue(String id, String name, Double price, int quantity){
        cue c = new cue(id, name, price, quantity, false);
        new CueDAO().getInstance().insert(c);
    }

    public void addNewItem(String id, String name, int quantity, Double price){
        item i = new item(id, name, quantity, price, false);
        new ItemDAO().getInstance().insert(i);
    }

    public void addNewCustomer(String id, String name, String phone){
        customer c = new customer(id, name, phone,0,  false);
        new customerDAO().getInstance().insert(c);
    }
}
