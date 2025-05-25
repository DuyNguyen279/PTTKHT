/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.doan.dao;

import com.doan.database.JDBCUtil;
import com.doan.model.reservation;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Asus
 */
public class ReservedDAO implements DaoInterface<reservation> {

    public static ReservedDAO getInstance() {
        return new ReservedDAO();
    }

    @Override
    public int insert(reservation t) {
        int ketqua = 0;
        Connection conn = JDBCUtil.getConnection();
        try {
            String sql = "INSERT INTO reservation (res_id, cus_id, tab_id, emp_id, start_time, status) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, t.getRes_id());
            ps.setString(2, t.getCus_id());
            ps.setString(3, t.getTab_id());
            ps.setString(4, t.getEmp_id());
            ps.setTimestamp(5, t.getStart_time() != null ? java.sql.Timestamp.valueOf(t.getStart_time()) : null);
            ps.setString(6, t.getStatus());
            ketqua = ps.executeUpdate();
            JDBCUtil.closeConnection(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketqua;
    }

    @Override
    public int update(reservation t) {
        int ketqua= 0;
        Connection conn = JDBCUtil.getConnection();
        try {
            String sql = "UPDATE reservation SET cus_id = ?, emp_id = ?, start_time = ?, status = ? WHERE res_id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, t.getCus_id());
            ps.setString(2, t.getEmp_id());
            ps.setTimestamp(3, t.getStart_time() != null ? java.sql.Timestamp.valueOf(t.getStart_time()) : null);
            ps.setString(4, t.getStatus());
            ps.setString(5, t.getRes_id());
            ketqua = ps.executeUpdate();
            JDBCUtil.closeConnection(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketqua;
    }

    @Override
    public int delete(reservation t) {
        int ketqua = 0;
        Connection conn = JDBCUtil.getConnection();
        try {
            String sql = "DELETE FROM reservation WHERE res_id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, t.getRes_id());
            ketqua = ps.executeUpdate();
            JDBCUtil.closeConnection(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketqua;
    }

    @Override
    public ArrayList<reservation> selectAll() {
        List<reservation> list = new ArrayList<>();
        Connection conn = JDBCUtil.getConnection();
        try {
            String sql = "SELECT * FROM reservation";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                java.sql.Timestamp timestamp = rs.getTimestamp("start_time");
                java.time.LocalDateTime startTime = timestamp != null ? timestamp.toLocalDateTime() : null;
                reservation t = new reservation(
                    rs.getString("res_id"),
                    rs.getString("cus_id"),
                    rs.getString("tab_id"),
                    rs.getString("emp_id"),
                    startTime,
                    rs.getString("status")
                );
                list.add(t);
            }
            JDBCUtil.closeConnection(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (ArrayList<reservation>) list;
    }

    @Override
    public reservation selectById(String id) {
        reservation t = null;
        Connection conn = JDBCUtil.getConnection();
        try {
            String sql = "SELECT * FROM reservation WHERE res_id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                java.sql.Timestamp timestamp = rs.getTimestamp("start_time");
                java.time.LocalDateTime startTime = timestamp != null ? timestamp.toLocalDateTime() : null;
                t = new reservation(
                    rs.getString("res_id"),
                    rs.getString("cus_id"),
                    rs.getString("tab_id"),
                    rs.getString("emp_id"),
                    startTime,
                    rs.getString("status")
                );
            }
            JDBCUtil.closeConnection(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return t;
    }

    public ArrayList<reservation> selectByTime(LocalDateTime t){
        List<reservation> list = new ArrayList<>();
        Connection conn = JDBCUtil.getConnection();
        try {
            String sql = "SELECT * FROM reservation WHERE start_time BETWEEN ? AND ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            LocalDateTime from = t.minusHours(2);
            LocalDateTime to = t.plusHours(2);
            ps.setTimestamp(1, java.sql.Timestamp.valueOf(from));
            ps.setTimestamp(2, java.sql.Timestamp.valueOf(to));
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                reservation t1 = new reservation(
                    rs.getString("res_id"),
                    rs.getString("cus_id"),
                    rs.getString("tab_id"),
                    rs.getString("emp_id"),
                    rs.getTimestamp("start_time") != null ? rs.getTimestamp("start_time").toLocalDateTime() : null,
                    rs.getString("status")
                );
                list.add(t1);
            }
            JDBCUtil.closeConnection(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (ArrayList<reservation>) list;
    }
	
}
