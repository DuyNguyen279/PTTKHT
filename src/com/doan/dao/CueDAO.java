/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.doan.dao;

import com.doan.database.JDBCUtil;
import com.doan.model.cue;
import java.sql.Connection;
import java.util.ArrayList;

/**
 *
 * @author Asus
 */
public class CueDAO implements DaoInterface<cue>{

    public static CueDAO getInstance(){
        return new CueDAO();
    }

    @Override
    public int insert(cue t) {
        int ketqua = 0;
        Connection conn = JDBCUtil.getConnection();
        try {
            String sql = "INSERT INTO cue (cue_id, cue_name, cue_price, cue_quantity, is_delete) VALUES (?, ?, ?, ?, ?)";
            java.sql.PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, t.getCue_id());
            ps.setString(2, t.getCue_name());
            ps.setDouble(3, t.getCue_price());
            ps.setInt(4, t.getCue_quantity());
            ps.setBoolean(5, t.isIs_delete());
            ketqua = ps.executeUpdate();
            JDBCUtil.closeConnection(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketqua;
    }

    @Override
    public int update(cue t) {
        int ketqua = 0;
        Connection conn = JDBCUtil.getConnection();
        try {
            String sql = "UPDATE cue SET cue_name = ?, cue_price = ?, cue_quantity = ?, is_delete = ? WHERE cue_id = ?";
            java.sql.PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, t.getCue_name());
            ps.setDouble(2, t.getCue_price());
            ps.setInt(3, t.getCue_quantity());
            ps.setBoolean(4, t.isIs_delete());
            ps.setString(5, t.getCue_id());
            ketqua = ps.executeUpdate();
            JDBCUtil.closeConnection(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketqua;
    }

    @Override
    public int delete(cue t) {
        int ketqua = 0;
        Connection conn = JDBCUtil.getConnection();
        try {
            String sql = "DELETE FROM cue WHERE cue_id = ?";
            java.sql.PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, t.getCue_id());
            ketqua = ps.executeUpdate();
            JDBCUtil.closeConnection(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketqua;
    }

    @Override
    public ArrayList<cue> selectAll() {
        ArrayList<cue> list = new ArrayList<>();
        Connection conn = JDBCUtil.getConnection();
        try {
            String sql = "SELECT * FROM cue";
            java.sql.PreparedStatement ps = conn.prepareStatement(sql);
            java.sql.ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                cue t = new cue(rs.getString("cue_id"), rs.getString("cue_name"), rs.getDouble("cue_price"), rs.getInt("cue_quantity"), rs.getBoolean("is_delete"));
                list.add(t);
            }
            JDBCUtil.closeConnection(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public cue selectById(String id) {
        cue t = null;
        Connection conn = JDBCUtil.getConnection();
        try {
            String sql = "SELECT * FROM cue WHERE cue_id = ?";
            java.sql.PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            java.sql.ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                t = new cue(rs.getString("cue_id"), rs.getString("cue_name"), rs.getDouble("cue_price"), rs.getInt("cue_quantity"), rs.getBoolean("is_delete"));
            }
            JDBCUtil.closeConnection(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return t;
    }
    
    public int softdelete(String id) {
        int ketqua = 0;
        Connection conn = JDBCUtil.getConnection();
        try {
            String sql = "UPDATE cue SET is_delete = ? WHERE cue_id = ?";
            java.sql.PreparedStatement ps = conn.prepareStatement(sql);
            ps.setBoolean(1, true);
            ps.setString(2, id);
            ketqua = ps.executeUpdate();
            JDBCUtil.closeConnection(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketqua;
    }
}
