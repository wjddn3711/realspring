package com.lee.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lee.board.impl.BoardDAO;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BoardController{
	// board
	@RequestMapping(value = "/board.do")
	public String board(BoardVO vo, BoardDAO dao, ModelAndView mav, HttpServletRequest request, Model model){
		System.out.println("로그 : board() @컨트롤러");
		model.addAttribute("data",dao.selectOne(vo));
		return "board.jsp";
	}

	// main
	@RequestMapping("/main.do")
	public String main(BoardVO vo, BoardDAO dao, ModelAndView mav, Model model){
		System.out.println("로그 : main 수행");
		model.addAttribute("datas",dao.selectAll(vo));
		return "main.jsp";
	}

	// update
	@RequestMapping(value = "/updateBoard.do")
	public String updateBoard(BoardVO vo, BoardDAO dao){
		System.out.println("로그 : update보드 수행중");
		dao.updateBoard(vo);
		return "main.do";
	}

	// insert
	@RequestMapping(value = "/insertBoard.do") // handlerMapping 대체
	public String insertBoard(BoardVO vo, BoardDAO dao){
		System.out.println("로그 : insertBoard() @컨트롤러");
		dao.insertBoard(vo);
		return "main.do";
	}

	// delete
	@RequestMapping(value = "/deleteBoard.do")
	public String deleteBoard(BoardVO vo, BoardDAO dao){
		System.out.println("로그 : deleteBoard 수행중");
		dao.deleteBoard(vo);
		return "main.do";
	}

}
