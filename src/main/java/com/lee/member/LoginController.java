package com.lee.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lee.member.impl.MemberDAO;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;


public class LoginController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		MemberVO vo=new MemberVO();
		vo.setMid(request.getParameter("mid"));
		vo.setPassword(request.getParameter("password"));
		MemberDAO dao=new MemberDAO();
		MemberVO data=dao.selectOne(vo);
		System.out.println("LC: "+data);
		ModelAndView mav = new ModelAndView();
		if(data!=null) {
			mav.addObject("member",data); // 만약 동작해버리면 /WEB-INF/test/main.do.jsp
			mav.setViewName("redirect:main.do");
		}
		else {
			mav.setViewName("redirect:login.jsp");
			// VR: 확장자여부확인 -> .jsp 자동추가
		}
		return mav;
	}

}
