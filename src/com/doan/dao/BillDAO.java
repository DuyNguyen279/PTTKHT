/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.doan.dao;

import com.doan.database.JDBCUtil;
import com.doan.model.bill;
import com.doan.model.cue;
import com.doan.model.item;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Asus
 */
public class BillDAO implements DaoInterface<bill> {

    public static BillDAO getInstance(){
        return new BillDAO();
    }
    @Override
    public int insert(bill t) {
        int ketqua = 0;
        Connection conn = JDBCUtil.getConnection();
        try {
            String sql = "INSERT INTO bill (bill_id, created_at, total, tab_id, emp_id, cus_id, is_done) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, t.getBill_id());
            ps.setTimestamp(2, Timestamp.valueOf(t.getCreated_at()));        
            ps.setDouble(3, t.getTotal());
            ps.setString(4, t.getTab_id());
            ps.setString(5, t.getEmp_id());
            ps.setString(6, t.getCus_id());
            ps.setBoolean(7, t.isIs_done());
            ketqua = ps.executeUpdate();
            sql = "INSERT INTO bill_cue (cue_id, bill_id, cue_quantity, total) VALUES (?, ?, ?, ?)";
            List<cue> listCue = t.getCues();
            for (cue cue : listCue) {
                PreparedStatement ps2 = conn.prepareStatement(sql);
                ps2.setString(1, cue.getCue_id());
                ps2.setString(2, t.getBill_id());
                ps2.setInt(3, cue.getCue_quantity());
                ps2.setDouble(4, cue.getCue_quantity() * cue.getCue_price());
                ketqua = ps2.executeUpdate();
            }
            sql = "INSERT INTO bill_item (bill_id, item_id, item_quantity, total) VALUES (?, ?, ?, ?)";
            List<item> listItem = t.getItems();
            for (item item : listItem) {
                PreparedStatement ps3 = conn.prepareStatement(sql);
                ps3.setString(1, t.getBill_id());
                ps3.setString(2, item.getItem_id());
                ps3.setInt(3, item.getItem_quantity());
                ps3.setDouble(4, item.getItem_quantity() * item.getItem_price());
                ketqua = ps3.executeUpdate();
            }
            JDBCUtil.closeConnection(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketqua;
    }

    @Override
    public int update(bill t) {
        // TODO Auto-generated method stub
        int ketqua = 0;
        Connection conn = JDBCUtil.getConnection();
        try {
            String sql = "UPDATE bill SET created_at = ?, total = ?, tab_id = ?, emp_id = ?, cus_id = ?, is_done = ? WHERE bill_id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setTimestamp(1, Timestamp.valueOf(t.getCreated_at()));
            ps.setDouble(2, t.getTotal());
            ps.setString(3, t.getTab_id());
            ps.setString(4, t.getEmp_id());
            ps.setString(5, t.getCus_id());
            ps.setBoolean(6, t.isIs_done());
            ps.setString(7, t.getBill_id());
            ketqua = ps.executeUpdate();
            JDBCUtil.closeConnection(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketqua;
    }

    @Override
    public int delete(bill t) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    public ArrayList<bill>getAllBill(){
        ArrayList<bill> list = new ArrayList<>();
        Connection conn = JDBCUtil.getConnection();
        try {
            String sql = "SELECT * FROM bill";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String bill_id = rs.getString("bill_id");
                Timestamp created_at = rs.getTimestamp("created_at");
                double total = rs.getDouble("total");
                String tab_id = rs.getString("tab_id");
                String emp_id = rs.getString("emp_id");
                String cus_id = rs.getString("cus_id");
                boolean is_done = rs.getBoolean("is_done");
                bill t = new bill(bill_id, created_at.toLocalDateTime(), total, new ArrayList<>(), new ArrayList<>(), emp_id, tab_id, cus_id,is_done);
                list.add(t);
            }
            JDBCUtil.closeConnection(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public ArrayList<bill> selectAll() {
        ArrayList<bill> list = new ArrayList<>();
        Connection conn = JDBCUtil.getConnection();
        try {
            String sql = "SELECT hd.bill_id, hd.created_at, hd.total, hd.tab_id, hd.emp_id, hd.cus_id, hd.is_done,sp.item_id, sp.item_quantity, co.cue_id, co.cue_quantity FROM bill hd JOIN bill_item sp ON hd.bill_id = sp.bill_id JOIN bill_cue co ON hd.bill_id = co.bill_id ORDER BY hd.bill_id;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            Map<String, bill> map = new HashMap<>();
            while (rs.next()) {
                String bill_id = rs.getString("bill_id");
                Timestamp created_at = rs.getTimestamp("created_at");
                double total = rs.getDouble("total");

                String tab_id = rs.getString("tab_id");
                String emp_id = rs.getString("emp_id");
                String cus_id = rs.getString("cus_id");

                String item_id = rs.getString("item_id");
                int item_quantity = rs.getInt("item_quantity");

                String cue_id = rs.getString("cue_id");
                int cue_quantity = rs.getInt("cue_quantity");

                boolean is_done = rs.getBoolean("is_done");

                bill t = map.get(bill_id);
                if (t==null){
                    t = new bill(bill_id, created_at.toLocalDateTime(), total,new ArrayList<>(), new ArrayList<>(), emp_id, tab_id, cus_id,is_done);
                    map.put(bill_id, t);
                }
                if (item_id != null) {
                    item it = new ItemDAO().getInstance().selectById(item_id);
                    it.setItem_quantity(item_quantity);
                    t.getItems().add(it);
                }
                if (cue_id != null) {
                    cue cu = new CueDAO().getInstance().selectById(cue_id);
                cu.setCue_quantity(cue_quantity);
                t.getCues().add(cu);
                } 

            }
            List<bill> listBill = new ArrayList<>(map.values());
            list.addAll(listBill);
            JDBCUtil.closeConnection(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public bill selectById(String id) {
        bill t = null;
        Connection conn = JDBCUtil.getConnection();
        try {
            String sql = "SELECT hd.bill_id, hd.created_at, hd.total, hd.tab_id, hd.emp_id, hd.cus_id, hd.is_done, sp.item_id, sp.item_quantity, co.cue_id, co.cue_quantity FROM bill hd LEFT JOIN bill_item sp ON hd.bill_id = sp.bill_id LEFT JOIN bill_cue co ON hd.bill_id = co.bill_id WHERE hd.bill_id = ? ORDER BY hd.bill_id;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String bill_id = rs.getString("bill_id");
                Timestamp created_at = rs.getTimestamp("created_at");
                double total = rs.getDouble("total");

                String tab_id = rs.getString("tab_id");
                String emp_id = rs.getString("emp_id");
                String cus_id = rs.getString("cus_id");

                String item_id = rs.getString("item_id");
                int item_quantity = rs.getInt("item_quantity");

                String cue_id = rs.getString("cue_id");
                int cue_quantity = rs.getInt("cue_quantity");

                boolean is_done = rs.getBoolean("is_done");

                if (t==null){
                    t = new bill(bill_id, created_at.toLocalDateTime(), total,new ArrayList<>(), new ArrayList<>(), emp_id, tab_id, cus_id,is_done);
                }
                if (item_id != null) {
                    item it = new ItemDAO().getInstance().selectById(item_id);
                    it.setItem_quantity(item_quantity);
                    t.getItems().add(it);
                }
                if (cue_id != null) {
                    cue cu = new CueDAO().getInstance().selectById(cue_id);
                cu.setCue_quantity(cue_quantity);
                t.getCues().add(cu);
                } 
            }
            JDBCUtil.closeConnection(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return t;
    }

    public bill getTmpBill(String tab_id){
        bill t = null;
        Connection conn = JDBCUtil.getConnection();
        try {
            String sql = "SELECT bill_id FROM bill WHERE tab_id = ? AND is_done = b'0';";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, tab_id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String bill_id = rs.getString("bill_id");
                t = selectById(bill_id);
            }
            JDBCUtil.closeConnection(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return t;
    }
    
    public void addItem(String bill_id, item i, double total){
        Connection conn = JDBCUtil.getConnection();
        try {
            String sql = "INSERT INTO bill_item (bill_id, item_id, item_quantity, total) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, bill_id);
            ps.setString(2, i.getItem_id());
            ps.setInt(3, i.getItem_quantity());
            ps.setDouble(4, i.getItem_price() * i.getItem_quantity());
            ps.executeUpdate();
            sql = "UPDATE bill SET total = ? WHERE bill_id = ?;";
            PreparedStatement ps2 = conn.prepareStatement(sql);
            ps2.setDouble(1, total);
            ps2.setString(2, bill_id);
            ps2.executeUpdate();
            JDBCUtil.closeConnection(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addCue(String bill_id, cue c, int quantity){
        Connection conn = JDBCUtil.getConnection();   
        try {
            String sql = "INSERT INTO bill_cue ( cue_id, bill_id, cue_quantity, total) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, c.getCue_id());
            ps.setString(2, bill_id);
            ps.setInt(3, quantity);
            ps.setDouble(4, c.getCue_price() * c.getCue_quantity());
            ps.executeUpdate();
            JDBCUtil.closeConnection(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateItem(String bill_id, item i, Double total){
        Connection conn = JDBCUtil.getConnection();
        try {
            String sql = "UPDATE bill_item SET item_quantity = ?, total = ? WHERE bill_id = ? AND item_id = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, i.getItem_quantity());
            ps.setDouble(2, i.getItem_price() * i.getItem_quantity());
            ps.setString(3, bill_id);
            ps.setString(4, i.getItem_id());
            ps.executeUpdate();
            sql = "UPDATE bill SET total = ? WHERE bill_id = ?;";
            PreparedStatement ps2 = conn.prepareStatement(sql);
            ps2.setDouble(1, total);
            ps2.setString(2, bill_id);
            ps2.executeUpdate();
            JDBCUtil.closeConnection(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
