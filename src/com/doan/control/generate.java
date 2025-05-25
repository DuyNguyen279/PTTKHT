/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.doan.control;

import com.doan.dao.BillDAO;
import com.doan.dao.CueDAO;
import com.doan.dao.ItemDAO;
import com.doan.dao.ReservedDAO;
import com.doan.dao.billiardTableDAO;
import com.doan.dao.customerDAO;
import com.doan.model.bill;
import com.doan.model.billiard_table;
import com.doan.model.cue;
import com.doan.model.customer;
import com.doan.model.item;
import com.doan.model.reservation;
import java.util.List;

/**
 *
 * @author Asus
 */
public class generate {
    public static generate getInstance() {
        return new generate();
    }

    public String generateIdTable(){
        List<billiard_table> all = billiardTableDAO.getInstance().selectAll();
        int i = all.size();
        int check = 1;
        while (check ==1 ){
            i++;
            for (billiard_table x : all){
                if (x.getTab_id().equals("tab"+i)){
                    check = 0;
                }
            }
            if (check == 0 ){
                check = 1;
            } else {
                return "tab"+i;
            }
        }
        return null;
    }

    public String generateIdCue(){
        List<cue> all = new CueDAO().getInstance().selectAll();
        int i = all.size();
        int check = 1;
        while (check ==1 ){
            i++;
            for (cue x : all){
                if (x.getCue_id().equals("cue"+i)){
                    check = 0;
                }
            }
            if (check == 0 ){
                check = 1;
            } else {
                return "cue"+i;
            }
        }
        return null;
    }

    public String generateIdItem(){
        List<item> all = new ItemDAO().getInstance().selectAll();
        int i = all.size();
        int check = 1;
        while (check ==1 ){
            i++;
            for (item x : all){
                if (x.getItem_id().equals("ite"+i)){
                    check = 0;
                }
            }
            if (check == 0 ){
                check = 1;
            } else {
                return "ite"+i;
            }
        }
        return null;
    }

    public String generateIdCus(){
        List<customer> all = new customerDAO().getInstance().selectAll();
        int i = all.size();
        int check = 1;
        while (check ==1){
            i++;
            for (customer x : all){
                if (x.getCus_id().equals("cus"+i)){
                    check = 0;
                }
            }
            if (check == 0 ){
                check = 1;
            } else {
                return "cus"+i;
            }
        }
        return null;
    }

    public String generateIdBill(){
        List<bill> all = new BillDAO().getInstance().getAllBill();
        int i = all.size();
        int check = 1;
        while (check ==1){
            i++;
            for (bill x : all){
                if (x.getBill_id().equals("bill"+i)){
                    check = 0;
                }
            }
            if (check == 0 ){
                check = 1;
            } else {
                return "bill"+i;
            }
        }
        return null;
    }

    public String generateIdReserve(){
        List<reservation> all = new ReservedDAO().getInstance().selectAll();
        int i = all.size();
        int check = 1;
        while (check ==1){
            i++;
            for (reservation x : all){
                if (x.getRes_id().equals("res"+i)){
                    check = 0;
                }
            }
            if (check == 0 ){
                check = 1;
            } else {
                return "res"+i;
            }
        }
        return null;
    }
}
