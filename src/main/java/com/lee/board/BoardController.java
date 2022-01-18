package com.lee.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lee.board.impl.BoardDAO;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller
@SessionAttributes("data")
public class BoardController{

	// @RequestMapping 보다 먼저 호출되는 @MA
	@ModelAttribute("conditionMap")
	public Map<String,String> searchConditionMap(){
		Map<String,String> conditionMap = new HashMap<String, String>();
		conditionMap.put("제목","title");
		conditionMap.put("작성자","writer");
		return conditionMap;
	}


	// board
	@RequestMapping(value = "/board.do")
	public String board(BoardVO vo, BoardDAO dao, ModelAndView mav, HttpServletRequest request, Model model){
		System.out.println("로그 : board() @컨트롤러");
		model.addAttribute("data",dao.selectOne(vo));
		return "board.jsp";
	}

	// main
	@RequestMapping("/main.do")
	public String main(@RequestParam(value = "searchCondition", defaultValue = "title", required = false)String searchCondition, @RequestParam(value = "searchContent", required = false)String searchContent, BoardVO vo, BoardDAO dao, ModelAndView mav, Model model){
		System.out.println("조건 : "+searchCondition);
		System.out.println("내용 : "+searchContent);
		System.out.println("로그 : main 수행");
		model.addAttribute("datas",dao.selectAll(vo));
		return "main.jsp";
	}

	// update
	@RequestMapping(value = "/updateBoard.do")
	public String updateBoard(@ModelAttribute("data")BoardVO vo, BoardDAO dao){
		System.out.println("로그 : update보드 수행중  "+ vo);
		System.out.println("작성자 : "+vo.getWriter());
		// 49번 라인에서 , data라는 이름의 @MA 성정을 추가했기 때문에 @SA -> null 방지 처리 진행됨!
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
		System.out.println(vo);
		dao.deleteBoard(vo);
		return "main.do";
	}


}
