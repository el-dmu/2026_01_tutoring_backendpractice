package com.dongyang.studyservlet;

import java.sql.*;

public class jdbcConnectUtil {
    public static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/servletdb", "root", "jinseo");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();

        }
        return  conn;
    }

    public static void close(Connection conn, PreparedStatement pstmt) {
        try {
            conn.close();
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void close(Connection conn, PreparedStatement pstmt, ResultSet rs) {
        try {
            conn.close();
            pstmt.close();
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
