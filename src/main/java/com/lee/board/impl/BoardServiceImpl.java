package com.lee.board.impl;

import java.util.List;

import com.lee.board.BoardService;
import com.lee.board.BoardVO;
import com.lee.common.LogAdvice;
import com.lee.common.LogAdvice2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("boardService")
public class BoardServiceImpl implements BoardService {
	@Autowired
	private BoardDAO boardDAO;


	@Override
	public void insertBoard(BoardVO vo) {

		boardDAO.insertBoard(vo);
		boardDAO.insertBoard(vo); // 트랜잭션 실습중
	}

	@Override
	public void updateBoard(BoardVO vo) {
		boardDAO.updateBoard(vo);
	}

	@Override
	public void deleteBoard(BoardVO vo) {
		// TODO Auto-generated method stub
		boardDAO.deleteBoard(vo);

	}

	@Override
	public BoardVO selectOne(BoardVO vo) {
		// TODO Auto-generated method stub
		return boardDAO.selectOne(vo);
	}

	@Override
	public List<BoardVO> selectAll(BoardVO vo) {
//		if(vo.getWriter().equals("티모")){
//			throw new IllegalArgumentException("일부러 발생시킨 예외");
//		}
		return boardDAO.selectAll(vo);
	}



}
