/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.doan.dao;

import com.doan.database.JDBCUtil;
import com.doan.model.employee;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Asus
 */
public class employeeDAO implements DaoInterface<employee> {
    public static employeeDAO getInstance(){
        return new employeeDAO();
    }

    @Override
    public int insert(employee t) {
        int ketqua = 0;
        Connection conn = JDBCUtil.getConnection();
        try {
            String sql = "INSERT INTO employees (emp_id, emp_name, emp_phone, email, is_delete, acc_id) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, t.getEmp_id());
            ps.setString(2, t.getEmp_name());
            ps.setString(3, t.getEmp_phone());
            ps.setString(4, t.getEmail());
            ps.setBoolean(5, t.isIs_delete());
            ps.setString(6, t.getAcc_id());
            ketqua = ps.executeUpdate();
            JDBCUtil.closeConnection(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketqua;
    }

    @Override
    public int update(employee t) {
        int ketqua = 0;
        Connection conn = JDBCUtil.getConnection();
        try {
            String sql = "UPDATE employees SET emp_name = ?, emp_phone = ?, email = ?, is_delete = ?, acc_id = ? WHERE emp_id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, t.getEmp_name());
            ps.setString(2, t.getEmp_phone());
            ps.setString(3, t.getEmail());
            ps.setBoolean(4, t.isIs_delete());
            ps.setString(5, t.getAcc_id());
            ps.setString(6, t.getEmp_id());
            ketqua = ps.executeUpdate();
            JDBCUtil.closeConnection(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketqua;
    }

    @Override
    public int delete(employee t) {
        int ketqua = 0;
        Connection conn = JDBCUtil.getConnection();
        try {
            String sql = "UPDATE employees SET is_delete = ? WHERE emp_id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setBoolean(1, t.isIs_delete());
            ps.setString(2, t.getEmp_id());
            ketqua = ps.executeUpdate();
            JDBCUtil.closeConnection(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketqua;
    }

    @Override
    public ArrayList<employee> selectAll() {
        ArrayList<employee> list = new ArrayList<>();
        Connection conn = JDBCUtil.getConnection();
        try {
            String sql = "SELECT * FROM employees WHERE is_delete = 0";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                employee t = new employee(rs.getString("emp_id"), rs.getString("emp_name"), rs.getString("emp_phone"), rs.getString("email"), rs.getBoolean("is_delete"), rs.getString("acc_id"));
                list.add(t);
            }
            JDBCUtil.closeConnection(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public employee selectById(String id) {
        employee t = null;
        Connection conn = JDBCUtil.getConnection();
        try {
            String sql = "SELECT * FROM employees WHERE emp_id = ? AND is_delete = 0";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                t = new employee(rs.getString("emp_id"), rs.getString("emp_name"), rs.getString("emp_phone"), rs.getString("email"), rs.getBoolean("is_delete"), rs.getString("acc_id"));
            }
            JDBCUtil.closeConnection(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return t;
    }

    public String getEmpIdByAccId(String acc_id) {
        String emp_id = null;
        Connection conn = JDBCUtil.getConnection();
        try {
            String sql = "SELECT emp_id FROM employees WHERE acc_id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, acc_id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                emp_id = rs.getString("emp_id");
            }
            JDBCUtil.closeConnection(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return emp_id;
    }

    public void softdelete (String id){
        Connection conn = JDBCUtil.getConnection();
        try {
            String sql = "UPDATE employees SET is_delete = 1 WHERE emp_id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            ps.executeUpdate();
            JDBCUtil.closeConnection(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
