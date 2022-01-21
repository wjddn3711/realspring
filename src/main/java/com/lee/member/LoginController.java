package com.lee.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lee.member.impl.MemberDAO;
import com.lee.member.impl.MemberDAO2;
import com.lee.member.impl.MemberServiceImpl;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SessionAttributes("user")
public class LoginController{
	// 오버로딩 			vs 	오버라이딩
	// 함수명 중복정의 허용	vs 	메서드 재정의
	@Autowired
	MemberService ms;
	// login
	@RequestMapping(value = "/login.do", method = RequestMethod.GET)
	public String showLogin(MemberVO vo){
		System.out.println("로그 : 요청방식 실습_GET");
		vo.setMid("kim");
		vo.setPassword("1234");
		return "login.jsp";
	}

	@RequestMapping(value = "/login.do", method = RequestMethod.POST)
	public String login(MemberVO vo, HttpSession session, Model model){
		System.out.println("로그 : login() @controller");
		MemberVO data = ms.selectOne(vo);
		if(data!=null) {
			model.addAttribute("user",data);
//			session.setAttribute("userName",data.getName());
			return "main.do";
//			mav.addObject("member",data); // 만약 동작해버리면 /WEB-INF/test/main.do.jsp
//			mav.setViewName("main.do");
		}
//		else {
//			mav.setViewName("login.jsp");
//			// VR: 확장자여부확인 -> .jsp 자동추가
//		}
		return "index.jsp";
	}
	// logout
	@RequestMapping(value = "/logout.do")
	public String logout(HttpSession session){
		System.out.println("로그 : logout() @controller");
		session.invalidate();
		return "login.jsp";
	}

	// signup
	@RequestMapping(value = "/signup.do")
	public String signup(MemberVO vo){
		System.out.println("로그 : signup() @controller");
		System.out.println(vo);
		try {
			ms.insert(vo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "login.jsp";
	}

	// mypage
	@RequestMapping(value = "/mypage.do", method = RequestMethod.GET)
	public String mypage(@ModelAttribute("user") MemberVO vo){
		System.out.println("get mypage @controller");
		System.out.println(vo);
		return "mypage.jsp";
	}
//
	@RequestMapping(value = "/mypage.do", method = RequestMethod.POST)
	public String mypage2(@ModelAttribute("user")MemberVO vo){
		System.out.println("post mypage @controller 변경");
		System.out.println(vo);
		ms.update(vo);
		return "main.do";
	}
}
