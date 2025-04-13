/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.doan.control;

import com.doan.dao.CueDAO;
import com.doan.dao.billiardTableDAO;
import com.doan.model.billiard_table;
import com.doan.model.cue;

/**
 *
 * @author Asus
 */
public class addNew {
    public static addNew getInstance() {
        return new addNew();
    }

    public void addNewBilliardTable(String id, String name, Double price){
        billiard_table table = new billiard_table(id, name, null, null, price, "Trống", false);
        new billiardTableDAO().getInstance().insert(table);
    }

    public void addNewCue(String id, String name, Double price, int quantity){
        cue c = new cue(id, name, price, quantity, false);
        new CueDAO().getInstance().insert(c);
    }
}
