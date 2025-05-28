/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.doan.control;

import com.doan.dao.CueDAO;
import com.doan.dao.ItemDAO;
import com.doan.dao.billiardTableDAO;
import com.doan.dao.customerDAO;
import com.doan.dao.employeeDAO;

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

    public void deleteItem(String id){
        new ItemDAO().getInstance().softdelete(id);
    }

    public void deleteCustomer(String id){
        new customerDAO().getInstance().softdelete(id);
    }

    public void deleteEmployee(String id){
        new employeeDAO().getInstance().softdelete(id);
    }
}
