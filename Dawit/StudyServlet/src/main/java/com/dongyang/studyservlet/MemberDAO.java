package com.dongyang.studyservlet;

import java.sql.*;
import java.util.ArrayList;

public class MemberDAO {
    static final String USER_LOGIN = "select * from memberTbl where memberid = ? and password = ?;";
    static final String USER_LIST = "select * from memberTbl;";
    public ArrayList<MemberDTO> selectAll() {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        conn = JdbcConnectUtil.getConnection();
        ArrayList<MemberDTO> aList = new ArrayList<MemberDTO>();
        try {
            pstmt = conn.prepareStatement(USER_LIST);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                MemberDTO mdto = new MemberDTO();
                mdto.setMemberid(rs.getString("memberid"));
                mdto.setPassword(rs.getString("password"));
                mdto.setName(rs.getString("name"));
                mdto.setEmail(rs.getString("email"));
                aList.add(mdto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcConnectUtil.close(conn, pstmt, rs);
        }
        return aList;
    }

    public boolean LoginCheck(MemberDTO mdto) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        boolean LoginResult = false;


        try {
            conn = JdbcConnectUtil.getConnection();
            pstmt = conn.prepareStatement(USER_LOGIN);
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
