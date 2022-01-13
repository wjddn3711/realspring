package com.lee.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lee.board.impl.BoardDAO;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;


public class InsertBoardController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		BoardVO vo=new BoardVO();
		vo.setContent(arg0.getParameter("content"));
		vo.setTitle(arg0.getParameter("title"));
		vo.setWriter(arg0.getParameter("writer"));
		BoardDAO dao=new BoardDAO();
		dao.insertBoard(vo);
		ModelAndView mav=new ModelAndView();
		mav.setViewName("redirect:main.do");
		return mav;
	}

}
