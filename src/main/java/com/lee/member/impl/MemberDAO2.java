package com.lee.member.impl;

import com.lee.member.MemberVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository("memberDAO")
public class MemberDAO2 {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    private String member_selectOne="select * from member2 where mid=? and password=?";

    public MemberVO selectOne(MemberVO vo) {
        Object[] obj = {vo.getMid(),vo.getPassword()};
        return jdbcTemplate.queryForObject(member_selectOne,obj, new MemberRowMapper());
    }
}
class MemberRowMapper implements RowMapper<MemberVO>{
    @Override
    public MemberVO mapRow(ResultSet rs, int i) throws SQLException {
        MemberVO data=new MemberVO();
        data.setMid(rs.getString("mid"));
        data.setName(rs.getString("name"));
        data.setPassword(rs.getString("password"));
        data.setRole(rs.getString("role"));
        return data;
    }
}
