/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.doan.control;

import com.doan.dao.CueDAO;
import com.doan.dao.billiardTableDAO;
import com.doan.model.billiard_table;
import com.doan.model.cue;
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
}
