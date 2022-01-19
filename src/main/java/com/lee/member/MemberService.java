package com.lee.member;

public interface MemberService {
	public MemberVO selectOne(MemberVO vo);
		// ex) 로그인 기능
	public void insert(MemberVO vo);
	public void update(MemberVO vo);
}
