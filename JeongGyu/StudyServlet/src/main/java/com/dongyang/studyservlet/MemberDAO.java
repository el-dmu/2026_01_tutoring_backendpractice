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
            while(rs.next()) {
                MemberDTO dto = new MemberDTO();
                dto.setMemberid(rs.getString("memberid"));
                dto.setPassword(rs.getString("password"));
                dto.setName(rs.getString("name"));
                dto.setEmail(rs.getString("email"));
                aList.add(dto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcConnectUtil.close(conn, pstmt, rs);
        }
        return aList;
    }

    public boolean loginCheck(MemberDTO mdto) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        boolean loginResult = false;

        try {
            conn = JdbcConnectUtil.getConnection();
            pstmt = conn.prepareStatement(USER_LOGIN);
            pstmt.setString(1, mdto.getMemberid());
            pstmt.setString(2, mdto.getPassword());
            rs = pstmt.executeQuery();
            loginResult = rs.next();
        } catch (SQLException e) {
             e.printStackTrace();
        } finally {
            JdbcConnectUtil.close(conn, pstmt, rs);
        }

        return loginResult;
    }

}
