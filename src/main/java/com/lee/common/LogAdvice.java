package com.lee.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Service // 1. @ 스캔범위에 추가
//@Aspect // 4. 에스펙트 설정 -> 실시간 위빙처리
public class LogAdvice {

    // JP: 스프링 컨테이너가 new JP() (==jp 객체화)
    // 현재 수행되는 비즈니스 메서드 정보를 세팅도 해줌

    //2. 포인트컷 설정
    @Pointcut("execution(* com.lee..*Impl.select*(..))")
    public void bPointcut() {}

    // 3. 어드바이스 설정 + 동작시점
    @Before("PointcutCommon.aPointcut()")
    public void printLog(JoinPoint jp){
        System.out.println("비즈니스 로직전에 출력하는 로그");
        String coreMethod = jp.getSignature().getName(); // 메서드 시그니처 (메서드명을 리턴)
        System.out.println("처리중인 비즈니스 메서드명 : "+coreMethod);
        Object[] objects = jp.getArgs();
        System.out.println("args 들");
        for (Object object : objects) {
            System.out.println(object);
        }
        System.out.println("여기까지");
    }
}
