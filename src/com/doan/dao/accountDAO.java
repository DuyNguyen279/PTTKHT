package com.doan.dao;

import com.doan.database.JDBCUtil;
import com.doan.model.account;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class accountDAO implements DaoInterface<account> {

    public static accountDAO getInstance(){
        return new accountDAO();
    }
    @Override
    public int insert(account t) {
        int ketqua = 0;
        Connection conn = JDBCUtil.getConnection();
        try {
            String sql = "INSERT INTO account (acc_id, acc_name, username, password, status, role) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, t.getAcc_id());
            ps.setString(2, t.getAcc_name());
            ps.setString(3, t.getUsername());
            ps.setString(4, t.getPassword());
            ps.setBoolean(4, t.getStatus());
            ps.setString(6, t.getRole());
            ketqua = ps.executeUpdate();
            JDBCUtil.closeConnection(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketqua;
    }

    @Override
    public int update(account t) {
        int ketqua = 0;
        Connection conn = JDBCUtil.getConnection();
        try {
            String sql = "UPDATE account SET acc_name = ?, username = ?, password = ?, status = ?, role = ? WHERE acc_id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, t.getAcc_name());
            ps.setString(2, t.getUsername());
            ps.setString(3, t.getPassword());
            ps.setBoolean(4, t.getStatus());
            ps.setString(5, t.getRole());
            ps.setString(6, t.getAcc_id());
            ketqua = ps.executeUpdate();
            JDBCUtil.closeConnection(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketqua;
    }

    @Override
    public int delete(account t) {
        int ketqua = 0;
        Connection conn = JDBCUtil.getConnection();
        try {
            String sql = "DELETE FROM account WHERE acc_id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, t.getAcc_id());
            ketqua = ps.executeUpdate();
            JDBCUtil.closeConnection(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketqua;
    }

    @Override
    public ArrayList<account> selectAll() {
        ArrayList<account> list = new ArrayList<>();
        Connection conn = JDBCUtil.getConnection();
        try {
            String sql = "SELECT * FROM account";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                account acc = new account();
                acc.setAcc_id(rs.getString("acc_id"));
                acc.setAcc_name(rs.getString("acc_name"));
                acc.setUsername(rs.getString("username"));
                acc.setPassword(rs.getString("password"));
                acc.setStatus(rs.getBoolean("status"));
                acc.setRole(rs.getString("role"));
                list.add(acc);
            }
            JDBCUtil.closeConnection(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public account selectById(String id) {
        account acc = null;
        Connection conn = JDBCUtil.getConnection();
        try {
            String sql = "SELECT * FROM account WHERE acc_id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                acc = new account();
                acc.setAcc_id(rs.getString("acc_id"));
                acc.setAcc_name(rs.getString("acc_name"));
                acc.setUsername(rs.getString("username"));
                acc.setPassword(rs.getString("password"));
                acc.setStatus(rs.getBoolean("status"));
                acc.setRole(rs.getString("role"));
            }
            JDBCUtil.closeConnection(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return acc;
    }
    
    public account selectByUsername(String username) {
        account tk = null;
        Connection conn = JDBCUtil.getConnection();
        try {
            String sql = "SELECT * FROM account tk WHERE tk.username =?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String acc_id = rs.getString("acc_id");
                String acc_name = rs.getString("acc_name");
                String password = rs.getString("password");
                boolean status = rs.getBoolean("status");
                String role = rs.getString("role");  
                tk = new account(acc_id, acc_name, username, password, status, role);  
            }
            JDBCUtil.closeConnection(conn);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }    
        return tk;
    }
}
