package com.lee.member;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.Scanner;


public class MemberClient {
	public static void main(String[] args) {
		AbstractApplicationContext factory=new GenericXmlApplicationContext("/WEB-INF/applicationContext.xml");
		
		MemberService ms=(MemberService)factory.getBean("memberService");
		Scanner sc = new Scanner(System.in);
		// 로그인 화면에서 ID,PW를 입력하고 로그인 버튼을 누름
		MemberVO vo=new MemberVO();

		System.out.println("회원 가입 form");
		System.out.print("회원 아이디를 입력하세요: ");
		vo.setMid(sc.next());
		System.out.print("회원 이름을 입력해주세요: ");
		vo.setName(sc.next());
		System.out.print("회원 비밀번호를 입력해주세요: ");
		vo.setPassword(sc.next());
		vo.setRole("USER");
		try {
			ms.insert(vo);
		} catch (Exception e) {
			System.out.println("트랜잭션 처리중 예외가 발생하였음");
		}


		vo.setMid("kim");
		vo.setPassword("1234");
		
		MemberVO data=ms.selectOne(vo);
		if(data==null) {
			System.out.println("로그인 실패!");
		}
		else {
			System.out.println(" ["+data.getRole()+"]"+data.getName()+"님,반갑습니다!:D");
		}
	
		factory.close();
	}
}
