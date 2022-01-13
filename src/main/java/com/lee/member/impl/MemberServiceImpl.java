package com.lee.member.impl;

import com.lee.member.MemberService;
import com.lee.member.MemberVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("memberService")
public class MemberServiceImpl implements MemberService {
	@Autowired
	private MemberDAO2 memberDAO;
//
//	public MemberDAO getMemberDAO() {
//		return memberDAO;
//	}
//	public void setMemberDAO(MemberDAO memberDAO) {
//		this.memberDAO = memberDAO;
//	}

	@Override
	public MemberVO selectOne(MemberVO vo) {
		return memberDAO.selectOne(vo);
	}

}