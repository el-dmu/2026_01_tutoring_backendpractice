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
            conn = JdbcConnectUtil.getConnection();
            pstmt = conn.prepareStatement("select * from memberTbl where memberid = ? and password = ?;");
            pstmt.setString(1, mdto.getMemberid());
            pstmt.setString(2, mdto.getPassword());
            rs = pstmt.executeQuery();

            loginResult = rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
           JdbcConnectUtil.close(conn,pstmt,rs);
        }
        return loginResult;
    }
}