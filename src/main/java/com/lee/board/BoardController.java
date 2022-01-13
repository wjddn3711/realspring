package com.lee.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lee.board.impl.BoardDAO;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class BoardController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		BoardVO vo=new BoardVO();
		vo.setBid(Integer.parseInt(request.getParameter("bid")));
		BoardDAO dao=new BoardDAO();
		BoardVO data=dao.selectOne(vo);
		
		HttpSession session=request.getSession();
		session.setAttribute("data", data);

		ModelAndView mav = new ModelAndView();
		mav.addObject("data",data);
		mav.setViewName("board");
		return mav;
	}

}
