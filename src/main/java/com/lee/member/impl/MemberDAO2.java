package com.lee.member.impl;

import com.lee.member.MemberVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

//@Repository("memberDAO")
public class MemberDAO2 {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    private String member_selectOne="select * from member2 where mid=? and password=?";
    private String member_insert ="insert into member2 values (?,?,?,?)";

    public MemberVO selectOne(MemberVO vo) throws Exception { // 모델에서 처리하지 않고 예외를 떠넘긴다
        Object[] obj = {vo.getMid(),vo.getPassword()};
        return jdbcTemplate.queryForObject(member_selectOne,obj, new MemberRowMapper());
    }

    public void insert(MemberVO vo) throws Exception{
        System.out.println("insert 수행중");
        jdbcTemplate.update(member_insert,vo.getMid(),vo.getPassword(),vo.getName(),vo.getRole());
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
