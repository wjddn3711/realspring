package com.lee.common;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Service
//@Aspect // ---> 스프링 컨테이너가 실행시간에 위빙처리
public class LogAdvice3 { // 횡단 관심 1개 + 포인트컷 2개 선언 => 불리 ----> 포인트컷 클래스 생성(예정)

    @Before("PointcutCommon.aPointcut()")
    public void pringtLog3(){
        System.out.println("횡단 관심");
    }
}
