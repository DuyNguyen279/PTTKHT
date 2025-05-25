/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.doan.dao;

import com.doan.database.JDBCUtil;
import com.doan.model.item;
import java.sql.Connection;
import java.util.ArrayList;

/**
 *
 * @author Asus
 */
public class ItemDAO implements DaoInterface<item> {
    public static ItemDAO getInstance(){
        return new ItemDAO();
    }

    @Override
    public int insert(item t) {
        int ketqua = 0;
        Connection conn = JDBCUtil.getConnection();
        try {
            String sql = "INSERT INTO item (item_id, item_name, item_price, item_quantity, is_delete) VALUES (?, ?, ?, ?, ?)";
            java.sql.PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, t.getItem_id());
            ps.setString(2, t.getItem_name());
            ps.setDouble(3, t.getItem_price());
            ps.setInt(4, t.getItem_quantity());
            ps.setBoolean(5, t.isIs_delete());
            ketqua = ps.executeUpdate();
            JDBCUtil.closeConnection(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketqua;
    }

    @Override
    public int update(item t) {
        int ketqua = 0;
        Connection conn = JDBCUtil.getConnection();
        try {
            String sql = "UPDATE item SET item_name = ?, item_price = ?, item_quantity = ?, is_delete = ? WHERE item_id = ?";
            java.sql.PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, t.getItem_name());
            ps.setDouble(2, t.getItem_price());
            ps.setInt(3, t.getItem_quantity());
            ps.setBoolean(4, t.isIs_delete());
            ps.setString(5, t.getItem_id());
            ketqua = ps.executeUpdate();
            JDBCUtil.closeConnection(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketqua;
    }

    @Override
    public int delete(item t) {
        int ketqua = 0;
        Connection conn = JDBCUtil.getConnection();
        try {
            String sql = "DELETE FROM item WHERE item_id = ?";
            java.sql.PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, t.getItem_id());
            ketqua = ps.executeUpdate();
            JDBCUtil.closeConnection(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketqua;
    }

    @Override
    public ArrayList<item> selectAll() {
        ArrayList<item> list = new ArrayList<>();
        Connection conn = JDBCUtil.getConnection();
        try {
            String sql = "SELECT * FROM item WHERE is_delete = 0";
            java.sql.PreparedStatement ps = conn.prepareStatement(sql);
            java.sql.ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String item_id = rs.getString("item_id");
                String item_name = rs.getString("item_name");
                double item_price = rs.getDouble("item_price");
                int item_quantity = rs.getInt("item_quantity");
                boolean is_delete = rs.getBoolean("is_delete");
                item t = new item(item_id, item_name, item_quantity, item_price, is_delete);
                list.add(t);
            }
            JDBCUtil.closeConnection(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public item selectById(String id) {
        item t = null;
        Connection conn = JDBCUtil.getConnection();
        try {
            String sql = "SELECT * FROM item WHERE item_id = ? AND is_delete = 0";
            java.sql.PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            java.sql.ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String item_id = rs.getString("item_id");
                String item_name = rs.getString("item_name");
                double item_price = rs.getDouble("item_price");
                int item_quantity = rs.getInt("item_quantity");
                boolean is_delete = rs.getBoolean("is_delete");
                t = new item(item_id, item_name, item_quantity, item_price, is_delete);
            }
            JDBCUtil.closeConnection(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return t;
    }

    public void softdelete(String id) {
        Connection conn = JDBCUtil.getConnection();
        try {
            String sql = "UPDATE item SET is_delete = 1 WHERE item_id = ?";
            java.sql.PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            ps.executeUpdate();
            JDBCUtil.closeConnection(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
