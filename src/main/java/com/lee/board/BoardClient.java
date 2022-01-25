package com.lee.board;

import java.util.List;

import com.lee.board.impl.BoardDAO3;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class BoardClient {

	public static void main(String[] args) {
		BoardDAO3 dao = new BoardDAO3();
		BoardVO vo = new BoardVO();
		vo.setContent("내용");
		vo.setTitle("제목");
		vo.setWriter("작성자!");
		vo.setFilepath("abc.png");
		dao.insertBoard(vo);

		List<BoardVO> datas = dao.selectAll(vo);
		for (BoardVO data : datas) {
			System.out.println(data);
		}
	}

}
