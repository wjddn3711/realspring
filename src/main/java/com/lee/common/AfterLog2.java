package com.lee.common;

import com.lee.member.MemberVO;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class AfterLog2 {
//    @After("PointcutCommon.bPointcut()")
    public void printLog(JoinPoint jp){
        System.out.println("수행 메서드는 :"+jp.getSignature().getName());
        Object[] args = jp.getArgs();
        // 수행 잘됨
        MemberVO vo= (MemberVO) args[0];
        System.out.println(vo.getMid()+" 님 환영합니다");
    }
}
