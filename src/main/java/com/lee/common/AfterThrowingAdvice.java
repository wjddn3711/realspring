package com.lee.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class AfterThrowingAdvice {

    @AfterThrowing(pointcut = "PointcutCommon.bPointcut()", throwing = "e")
    public void exceptionLog(JoinPoint jp, Exception e) {
        String coreMethod = jp.getSignature().getName();
        System.out.println("비즈니스 메서드  "+coreMethod+"() 수행중에 문제, 예외 발생시 출력");
        System.out.println("예외 메시지: "+e.getMessage());

        if(e instanceof IllegalArgumentException){
            System.out.println("사용하지 않는 매개변수 입니다");
        }
        else if(e instanceof NullPointerException){
            System.out.println("객체생성 실패했습니다");
        }
        else {
            System.out.println("현재 예외는 파악되지 않은 예외입니다! 분석이 필요합니다");
        }
    }
}
