/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.doan.control;

import com.doan.dao.BillDAO;
import com.doan.dao.CueDAO;
import com.doan.dao.billiardTableDAO;
import com.doan.model.bill;
import com.doan.model.billiard_table;
import com.doan.model.cue;
import java.time.LocalDateTime;

/**
 *
 * @author Asus
 */
public class play {
    public static play getInstance(){
        return new play();
    }

    public void playGame(String idTable, String emp_id){
        billiard_table table = new billiardTableDAO().getInstance().selectById(idTable);
        table.setStart(LocalDateTime.now());
        table.setEnd(null);
        table.setStatus("Đang sử dụng");
        bill tmp = new bill();
        tmp.setBill_id(new generate().getInstance().generateIdBill());
        tmp.setCreated_at(LocalDateTime.now());
        tmp.setTab_id(idTable);
        tmp.setEmp_id(emp_id);
        tmp.setCus_id("cus0");
        new billiardTableDAO().getInstance().update(table);
        new BillDAO().getInstance().insert(tmp);
    }

    public void addCueToBill(String bill_id, cue c, int quantity) {
        new BillDAO().getInstance().addCue(bill_id, c, quantity);
        c.setCue_quantity(c.getCue_quantity() - quantity);
        new CueDAO().getInstance().update(c);
    }
}
