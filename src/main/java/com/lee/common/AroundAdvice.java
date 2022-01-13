package com.lee.common;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;


@Service
public class AroundAdvice {

    @Pointcut("execution(* com.lee..*Impl.select*(..))")
    public void bPointcut() {}

    @Around("bPointcut()")
    public Object aroundLog(ProceedingJoinPoint pjp){
        System.out.println("[비즈니스 메서드 수행전]");

        StopWatch sw = new StopWatch();
        sw.start();
        Object obj = null; // 비즈니스 메서드를 탈취
        try {
            obj = pjp.proceed();
        } catch (Throwable e) {
            e.printStackTrace();
        }
        sw.stop();
        System.out.println("[비즈니스 메서드 수행후]");
        System.out.println(pjp.getSignature().getName()+"() 비즈니스 메서드 소요시간은 "); // 실행중인 메서드명 출력
        System.out.println(sw.getTotalTimeMillis()+" 밀리초입니다");

        return obj;
    }
}
