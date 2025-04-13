/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.doan.control;

import com.doan.dao.CueDAO;
import com.doan.dao.billiardTableDAO;

/**
 *
 * @author Asus
 */
public class delete {
    public static delete getInstance(){
        return new delete();
    }

    public void  deleteBilliardTable(String id){
        new billiardTableDAO().getInstance().softdelete(id);
    }

    public void deleteCue(String id){
        new CueDAO().getInstance().softdelete(id);
    }
}
