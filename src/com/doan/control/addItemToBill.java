/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.doan.control;

import com.doan.dao.BillDAO;
import com.doan.dao.ItemDAO;
import com.doan.model.item;

/**
 *
 * @author Asus
 */
public class addItemToBill {
    public static addItemToBill getInstance(){
        return new addItemToBill();
    }

    public void add(String b, item i, int quantity, double total) {
        new ItemDAO().getInstance().update(new item(i.getItem_id(), i.getItem_name(), i.getItem_quantity() - quantity, i.getItem_price(), i.isIs_delete()));
        i.setItem_quantity(quantity);
        new BillDAO().getInstance().addItem(b, i, total);
    }

    public void update(String b, item i,int maxQuantity, int quantity, double total) {
        new ItemDAO().getInstance().update(new item(i.getItem_id(), i.getItem_name(), maxQuantity - quantity, i.getItem_price(), i.isIs_delete()));
        new BillDAO().getInstance().updateItem(b, i, total);
    }

}
