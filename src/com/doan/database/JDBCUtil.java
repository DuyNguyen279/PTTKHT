/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.doan.database;

import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author Asus
 */
public class JDBCUtil {
    public static Connection getConnection(){
        final String url = "jdbc:mysql://localhost:3306/pttkht";
        final String user = "root";
        final String password = "123456";
        try{
            Class.forName("com.mysql.jdbc.Driver");
            return java.sql.DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException | SQLException e){
        }
        return null;
    }
    public static void closeConnection(Connection c) {
		try {
			if(c!=null) {
				c.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
    
    public static void main(String[] args){
        Connection conn = getConnection();
        if (conn != null){
            System.out.println("Thanh Cong");
        } else{
            System.out.println("That bai");
        }
    }
}
