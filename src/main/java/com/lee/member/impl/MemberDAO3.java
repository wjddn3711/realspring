package com.lee.member.impl;

import com.lee.board.SqlSessionFactoryBean;
import com.lee.member.MemberVO;
import org.apache.ibatis.session.SqlSession;

public class MemberDAO3 {
    private SqlSession mybatis;
    public MemberDAO3(){
        mybatis = SqlSessionFactoryBean.getSqlSessionInstance(); //jdbcutil 과 같은 역할
    }

    public void insert(MemberVO vo){
        mybatis.insert("MemberDAO.insert",vo);
        mybatis.commit();
    }

    public void update(MemberVO vo){
        mybatis.update("MemberDAO.update", vo);
        mybatis.commit();
    }

    public MemberVO selectOne(MemberVO vo){
        return mybatis.selectOne("MemberDAO.selectOne",vo);
    }
}
