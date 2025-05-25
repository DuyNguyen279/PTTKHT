/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.doan.dao;

import com.doan.database.JDBCUtil;
import com.doan.model.billiard_table;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 *
 * @author Asus
 */
public class billiardTableDAO implements DaoInterface<billiard_table> {
    public static billiardTableDAO getInstance(){
        return new billiardTableDAO();
    }

    @Override
    public int insert(billiard_table t) {
        int ketqua = 0;
        Connection conn = JDBCUtil.getConnection();
        try {
            String sql = "INSERT INTO billiard_table (tab_id, tab_name, start, end, tab_price, tab_type, tab_status, is_delete) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, t.getTab_id());
            ps.setString(2, t.getTab_name());
            ps.setTimestamp(3, t.getStart() != null ? java.sql.Timestamp.valueOf(t.getStart()) : null);
            ps.setTimestamp(4, t.getEnd() != null ? java.sql.Timestamp.valueOf(t.getEnd()) : null);
            ps.setDouble(5, t.getTab_price());
            ps.setString(6, t.getTab_type());
            ps.setString(7, t.getStatus());
            ps.setBoolean(8, t.isIs_delete());
            ketqua = ps.executeUpdate();
            JDBCUtil.closeConnection(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketqua;
    }

    @Override
    public int update(billiard_table t) {
        int ketqua = 0;
        Connection conn = JDBCUtil.getConnection();
        try {
            String sql = "UPDATE billiard_table SET tab_name = ?, start = ?, end = ?, tab_price = ?,tab_type = ?, tab_status = ?, is_delete = ? WHERE tab_id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, t.getTab_name());
            ps.setTimestamp(2, t.getStart() != null ? java.sql.Timestamp.valueOf(t.getStart()) : null);
            ps.setTimestamp(3, t.getEnd() != null ? java.sql.Timestamp.valueOf(t.getEnd()) : null);
            ps.setDouble(4, t.getTab_price());
            ps.setString(5, t.getTab_type());
            ps.setString(6, t.getStatus());
            ps.setBoolean(7, t.isIs_delete());
            ps.setString(8, t.getTab_id());
            ketqua = ps.executeUpdate();
            JDBCUtil.closeConnection(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketqua;
    }

    @Override
    public int delete(billiard_table t) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public ArrayList<billiard_table> selectAll() {
        ArrayList<billiard_table> list = new ArrayList<>();
        Connection conn = JDBCUtil.getConnection();
        try {
            String sql = "SELECT * FROM billiard_table";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String tab_id = rs.getString("tab_id");
                String tab_name = rs.getString("tab_name");
                LocalDateTime start = rs.getTimestamp("start") != null ? rs.getTimestamp("start").toLocalDateTime() : null;
                LocalDateTime end = rs.getTimestamp("end") != null ? rs.getTimestamp("end").toLocalDateTime() : null;
                Double tab_price = rs.getDouble("tab_price");
                String tab_type = rs.getString("tab_type");
                String status = rs.getString("tab_status");
                boolean is_delete = rs.getBoolean("is_delete");
                billiard_table table = new billiard_table(tab_id, tab_name, start, end, tab_price, tab_type, status, is_delete);
                list.add(table);
            }
            JDBCUtil.closeConnection(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public billiard_table selectById(String id) {
        billiard_table table = null;
        Connection conn = JDBCUtil.getConnection();
        try {
            String sql = "SELECT * FROM billiard_table WHERE tab_id = ? AND is_delete = 0";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String tab_id = rs.getString("tab_id");
                String tab_name = rs.getString("tab_name");
                LocalDateTime start = rs.getTimestamp("start") != null ? rs.getTimestamp("start").toLocalDateTime() : null;
                LocalDateTime end = rs.getTimestamp("end") != null ? rs.getTimestamp("end").toLocalDateTime() : null;
                Double tab_price = rs.getDouble("tab_price");
                String tab_type = rs.getString("tab_type");
                String status = rs.getString("tab_status");
                boolean is_delete = rs.getBoolean("is_delete");
                table = new billiard_table(tab_id, tab_name, start, end, tab_price, tab_type, status, is_delete);
            }
            JDBCUtil.closeConnection(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return table;
    }

    public int softdelete(String id){
        int ketqua = 0;
        billiard_table t = selectById(id);
        t.setIs_delete(true);
        Connection conn = JDBCUtil.getConnection();
        try {
            String sql = "UPDATE billiard_table SET tab_name = ?, start = ?, end = ?, tab_price = ?, tab_status = ?, is_delete = ? WHERE tab_id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, t.getTab_name());
            ps.setTimestamp(2, t.getStart() != null ? java.sql.Timestamp.valueOf(t.getStart()) : null);
            ps.setTimestamp(3, t.getEnd() != null ? java.sql.Timestamp.valueOf(t.getEnd()) : null);
            ps.setDouble(4, t.getTab_price());
            ps.setString(5, t.getStatus());
            ps.setBoolean(6, t.isIs_delete());
            ps.setString(7, t.getTab_id());
            ketqua = ps.executeUpdate();
            JDBCUtil.closeConnection(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketqua;
    }
    
}
