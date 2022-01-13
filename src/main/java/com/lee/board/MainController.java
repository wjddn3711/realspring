package com.lee.board;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lee.board.impl.BoardDAO;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;


public class MainController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
	
		BoardVO vo=new BoardVO(); // 검색을 위해 vo파라미터 제작했으나, 현재 구현안된기능
		BoardDAO dao=new BoardDAO();
		List<BoardVO> datas=dao.selectAll(vo);
		
		ModelAndView mav=new ModelAndView();
		mav.addObject("datas", datas);
		mav.setViewName("main");
		return mav;
	}

}