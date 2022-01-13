package com.lee.common;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect // 횡단 관심과 "결합"될때 불리는 포인트컷 클래스
public class PointcutCommon {
    @Pointcut("execution(* com.lee..*Impl.select*(..))")
    public void bPointcut() {}

    @Pointcut("execution(* com.lee..*Impl.*(..))")
    public void aPointcut() {}
}
