/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.doan.control;

import com.doan.dao.BillDAO;
import com.doan.dao.billiardTableDAO;
import com.doan.dao.customerDAO;
import com.doan.model.bill;
import com.doan.model.billiard_table;
import com.doan.model.customer;

/**
 *
 * @author Asus
 */
public class end {
    public static end getInstance(){
        return new end();
    }
    
    public int updateCusPoint(customer cus){
        return new customerDAO().getInstance().update(cus);
    }

    public int updateBill(bill b){
        return new BillDAO().getInstance().update(b);
    }

    public int updateTab(billiard_table tab){
        return new billiardTableDAO().getInstance().update(tab);
    }
}
