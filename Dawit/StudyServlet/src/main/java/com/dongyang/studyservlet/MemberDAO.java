package com.dongyang.studyservlet;

import java.sql.*;

public class MemberDAO {

    public boolean LoginCheck(MemberDTO mdto) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        boolean LoginResult = false;


        try {
            conn = JdbcConnectUtil.getConnection();
            pstmt = conn.prepareStatement("select * from memberTbl where memberid = ? and password = ?;");
            pstmt.setString(1, mdto.getMemberid());
            pstmt.setString(2, mdto.getPassword());
            rs = pstmt.executeQuery();
            LoginResult = rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcConnectUtil.close(conn, pstmt, rs);
        }

        return LoginResult;
    }

}
