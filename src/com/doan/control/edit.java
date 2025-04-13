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
public class edit {
    public static edit getInstance() {
        return new edit();
    }

    public void editBilliardTable(String id, String name, Double price, String status) {
        billiard_table table = new billiard_table(id, name, null, null, price, status, false);
        new billiardTableDAO().getInstance().update(table);
    }

    public void editCue(String id, String name, Double price, int quantity) {
        cue c = new cue(id, name, price, quantity, false);
        new CueDAO().getInstance().update(c);
    }
}
