package com.lee.board.impl;

import com.lee.board.BoardVO;
import com.lee.board.SqlSessionFactoryBean;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class BoardDAO3 {
    private SqlSession mybatis;
    public BoardDAO3() {
        mybatis = SqlSessionFactoryBean.getSqlSessionInstance();
    }

    public void insertBoard(BoardVO vo){
        mybatis.insert("BoardDAO.insertBoard",vo);
        mybatis.commit(); // 기본이 autocommit
    }

    public void updateBoard(BoardVO vo){
        mybatis.update("BoardDAO.updateBoard",vo);
        mybatis.commit(); // 기본이 autocommit
    }

    public void deleteBoard(BoardVO vo){
        mybatis.insert("BoardDAO.deleteBoard",vo);
        mybatis.commit(); // 기본이 autocommit
    }

    public List<BoardVO> selectAll(BoardVO vo){
        return mybatis.selectList("BoardDAO.selectAll",vo);
    }

    public BoardVO selectOne(BoardVO vo){
        return mybatis.selectOne("BoardDAO.selectOne",vo);
    }
}
