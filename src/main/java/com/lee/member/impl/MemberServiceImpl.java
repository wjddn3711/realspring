package com.lee.member.impl;

import com.lee.member.MemberService;
import com.lee.member.MemberVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("memberService")
public class MemberServiceImpl implements MemberService {
	@Autowired
	private MemberDAO memberDAO;
//
//	public MemberDAO getMemberDAO() {
//		return memberDAO;
//	}
//	public void setMemberDAO(MemberDAO memberDAO) {
//		this.memberDAO = memberDAO;
//	}

	@Override
	public MemberVO selectOne(MemberVO vo) {
		try {
			return memberDAO.selectOne(vo);
		} catch (Exception e) {
			return null; // 문제가 있는 경우 null을 반환하도록
		}
	}

//	@Override
//	public void insert(MemberVO vo) throws Exception{
//			memberDAO.insert(vo);
//			memberDAO.insert(vo);
//	}

}