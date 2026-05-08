package com.dongyang.studyservlet;

import javax.xml.transform.Result;
import java.sql.*;

public class MemberDAO {
    public boolean loginCheck(MemberDTO mdto){
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        boolean loginResult = false;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/servletdb", "root", "");
            pstmt = conn.prepareStatement("select * from memberTbl where memberid = ? and password = ?;");
            pstmt.setString(1, mdto.getMemberid());
            pstmt.setString(2, mdto.getPassword());
            rs = pstmt.executeQuery();

            loginResult = rs.next();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            try{
            conn.close();
            pstmt.close();
            rs.close();
            }  catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return loginResult;
    }
}