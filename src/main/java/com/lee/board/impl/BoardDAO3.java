package com.lee.board.impl;

import com.lee.board.BoardVO;
import com.lee.board.SqlSessionFactoryBean;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

// 1. 상속
// 2. @
@Repository("boardDAO")
public class BoardDAO3  {

    @Autowired
    private SqlSessionTemplate mybatis;

    public void insertBoard(BoardVO vo){
        mybatis.insert("BoardDAO.insertBoard",vo);
    }

    public void updateBoard(BoardVO vo){
        mybatis.update("BoardDAO.updateBoard",vo);
    }

    public void deleteBoard(BoardVO vo){
        mybatis.insert("BoardDAO.deleteBoard",vo);
    }

    public List<BoardVO> selectAll(BoardVO vo){
        if(vo.getSearchCondition().equals("title")){
            return mybatis.selectList("BoardDAO.selectT",vo);
        }
        return mybatis.selectList("BoardDAO.selectW",vo);
    }

    public BoardVO selectOne(BoardVO vo){
        return mybatis.selectOne("BoardDAO.selectOne",vo);
    }
}
