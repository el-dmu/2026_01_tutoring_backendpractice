package com.dongyang.studyservlet;

import javax.xml.transform.Result;
import java.net.ConnectException;
import java.sql.*;
import java.util.prefs.Preferences;

public class MemberDAO {
    public boolean loginCheck(MemberDTO mdto) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        boolean loginResult  = false;


        try {
            conn = jdbcConnectUtil.getConnection();
            pstmt = conn.prepareStatement("select * from memberTbl where memberid = ? and password = ?");
            pstmt.setString(1, mdto.getMemberid());
            pstmt.setString(2, mdto.getPassword());
            rs = pstmt.executeQuery();
            loginResult = rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            jdbcConnectUtil.close(conn,pstmt,rs);
        }
        return loginResult;
    }
}
