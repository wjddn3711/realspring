package com.lee.board.impl;

/*
BoarDAO 의 한계: 중복코드가 많음
-> JDBCTemplate 사용
    1) JdbcDAOSupport 클래스를 상속받아서 구현 -> 강제성이 부족 public void setSuperDataSource 를 직접 만들어야함
    2) JdbcTemplate 클래스 <bean> 등록하여 DI ★ (spring boot 가 나옴에 따라 bean 등록된 것에 대한 활용도가 더 높아졌다)
 */


import com.lee.board.BoardVO;
import com.lee.common.JDBCUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//@Repository("boardDAO")
public class BoardDAO2{
    @Autowired
    private JdbcTemplate jdbcTemplate;
    private String board_insert="insert into board2(title,writer,content,bdate,file) values(?,?,?,now(),?)";
    private String board_update="update board2 set title=?,content=? where bid=?";
    private String board_delete="delete board2 where bid=?";
    private String board_selectOne="select * from board2 where bid=?";
    private String board_selectAll="select * from board2 order by bid desc";
    // 작성자로 검색
    private String board_selectSearchWriter = "select * from board2 where writer like ? order by bid desc";
    // 제목으로 검색
    private String board_selectSearchTitle = "select * from board2 where title like ? order by bid desc";


//    @Autowired // 주로 멤버변수 위에서 타입을 먼저보고 DI
//    public void setSuperDataSource(DataSource dataSource){
//        super.setDataSource(dataSource); // 템플릿에서 요구하는 데이터 소스를 넣을 수 있게 된다
//    }
    // ds 객체를 사용할 수 있는 코드 존재
    // ds 객체 주입



    public void insertBoard(BoardVO vo) {
        System.out.println("insert 수행중"+vo.getFilepath()) ;
        jdbcTemplate.update(board_insert,vo.getTitle(),vo.getWriter(),vo.getContent(),vo.getFilepath());
    }
    public void updateBoard(BoardVO vo) {
        System.out.println("update 수행중");
        jdbcTemplate.update(board_update,vo.getTitle(),vo.getContent(),vo.getBid());
    }
    public void deleteBoard(BoardVO vo) {
        System.out.println("delete 수행중");
        jdbcTemplate.update(board_delete,vo.getBid());
    }
    public BoardVO selectOne(BoardVO vo) {
        System.out.println("selectOne수행중");
        Object[] obj = {vo.getBid()};
        return jdbcTemplate.queryForObject(board_selectOne,obj, new BoardRowMapper());
    }
    public List<BoardVO> selectAll(BoardVO vo) {
        System.out.println("selectAll 수행중");
        String sql;

        if(vo.getSearchCondition().equals("title")){
            sql = board_selectSearchTitle;
        }
        else {
            sql = board_selectSearchWriter;
        }
        return jdbcTemplate.query(sql, new BoardRowMapper(),"%"+vo.getSearchContent()+"%");

    }
}

class BoardRowMapper implements RowMapper<BoardVO> {

    @Override
    public BoardVO mapRow(ResultSet rs, int i) throws SQLException {
        BoardVO data=new BoardVO();
        data.setBdate(rs.getDate("bdate"));
        data.setBid(rs.getInt("bid"));
        data.setCnt(rs.getInt("cnt"));
        data.setContent(rs.getString("content"));
        data.setTitle(rs.getString("title"));
        data.setWriter(rs.getString("writer"));
        data.setFilepath(rs.getString("file"));
        return data;
    }
}