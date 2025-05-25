/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.doan.dao;

import com.doan.database.JDBCUtil;
import com.doan.model.customer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Asus
 */
public class customerDAO implements DaoInterface<customer> {

    public static customerDAO getInstance(){
        return new customerDAO();
    }
    @Override
    public int insert(customer t) {
        int ketqua = 0;
        Connection conn = JDBCUtil.getConnection();
        try {
            String sql = "INSERT INTO customer (cus_id, cus_name, cus_phone, point, is_delete) VALUES (?, ?, ?, ?, ?)";
            java.sql.PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, t.getCus_id());
            ps.setString(2, t.getCus_name());
            ps.setString(3, t.getCus_phone());
            ps.setInt(4, t.getPoint());
            ps.setBoolean(5, t.isIs_delete());
            ketqua = ps.executeUpdate();
            JDBCUtil.closeConnection(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketqua;
    }

    @Override
    public int update(customer t) {
        int ketqua = 0;
        Connection conn = JDBCUtil.getConnection();
        try {
            String sql = "UPDATE customer SET cus_name = ?, cus_phone = ?, point = ?, is_delete = ? WHERE cus_id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, t.getCus_name());
            ps.setString(2, t.getCus_phone());
            ps.setInt(3, t.getPoint());
            ps.setBoolean(4, t.isIs_delete());
            ps.setString(5, t.getCus_id());
            ketqua = ps.executeUpdate();
            JDBCUtil.closeConnection(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketqua;
    }

    @Override
    public int delete(customer t) {
        int ketqua = 0;
        Connection conn = JDBCUtil.getConnection();
        try {
            String sql = "UPDATE customer SET is_delete = ? WHERE cus_id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setBoolean(1, t.isIs_delete());
            ps.setString(2, t.getCus_id());
            ketqua = ps.executeUpdate();
            JDBCUtil.closeConnection(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketqua;
    }

    @Override
    public ArrayList<customer> selectAll() {
        ArrayList<customer> list = new ArrayList<>();
        Connection conn = JDBCUtil.getConnection();
        try {
            String sql = "SELECT * FROM customer WHERE is_delete = 0";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                customer t = new customer();
                t.setCus_id(rs.getString("cus_id"));
                t.setCus_name(rs.getString("cus_name"));
                t.setCus_phone(rs.getString("cus_phone"));
                t.setPoint(rs.getInt("point"));
                t.setIs_delete(rs.getBoolean("is_delete"));
                list.add(t);
            }
            JDBCUtil.closeConnection(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public customer selectById(String id) {
        customer t = null;
        Connection conn = JDBCUtil.getConnection();
        try {
            String sql = "SELECT * FROM customer WHERE cus_id = ? AND is_delete = 0";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                t = new customer();
                t.setCus_id(rs.getString("cus_id"));
                t.setCus_name(rs.getString("cus_name"));
                t.setCus_phone(rs.getString("cus_phone"));
                t.setPoint(rs.getInt("point"));
                t.setIs_delete(rs.getBoolean("is_delete"));
            }
            JDBCUtil.closeConnection(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return t;
    }  

    public customer selectByPhone(String phone) {
        customer t = null;
        Connection conn = JDBCUtil.getConnection();
        try {
            String sql = "SELECT * FROM customer WHERE cus_phone = ? AND is_delete = 0";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, phone);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                t = new customer();
                t.setCus_id(rs.getString("cus_id"));
                t.setCus_name(rs.getString("cus_name"));
                t.setCus_phone(rs.getString("cus_phone"));
                t.setPoint(rs.getInt("point"));
                t.setIs_delete(rs.getBoolean("is_delete"));
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
            String sql = "UPDATE customer SET is_delete = 1 WHERE cus_id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            ps.executeUpdate();
            JDBCUtil.closeConnection(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
