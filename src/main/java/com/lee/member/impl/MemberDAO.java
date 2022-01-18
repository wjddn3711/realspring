package com.lee.member.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.lee.common.JDBCUtil;
import com.lee.member.MemberVO;
import org.springframework.stereotype.Repository;


@Repository("memberDAO")
public class MemberDAO {
	private Connection conn=null;
	private PreparedStatement pstmt=null;
	private ResultSet rs=null;
	
	private String member_selectOne="select * from member2 where mid=? and password=?";
	private String member_update ="update member set password=?,name=? where mid=?";

	public void updateMember(MemberVO vo){
		try {
			conn=JDBCUtil.connect();
			pstmt = conn.prepareStatement(member_update);
			pstmt.setString(1,vo.getPassword());
			pstmt.setString(2,vo.getName());
			pstmt.setString(3,vo.getMid());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
	}

	public MemberVO selectOne(MemberVO vo) {
		MemberVO data=null;
		conn= JDBCUtil.connect();
		try {
			pstmt=conn.prepareStatement(member_selectOne);
			pstmt.setString(1, vo.getMid());
			pstmt.setString(2, vo.getPassword());
			rs=pstmt.executeQuery();
			if(rs.next()) {
				data=new MemberVO();
				data.setMid(rs.getString("mid"));
				data.setName(rs.getString("name"));
				data.setPassword(rs.getString("password"));
				data.setRole(rs.getString("role"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(rs, pstmt, conn);
		}	
		return data;
	}
}
