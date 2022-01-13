package com.lee.common;

import com.lee.board.BoardVO;
import com.lee.member.MemberVO;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Service
//@Aspect
public class AfterReturningAdvice {

    @Pointcut("execution(* com.lee..*Impl.select*(..))")
    public void bPointcut() {}

    @AfterReturning(pointcut = "PointcutCommon.aPointcut()",returning = "obj")
    public void afterLog(JoinPoint jp, Object obj){ // obj: "바인드변수" ★
        String coreMethod = jp.getSignature().getName(); // 지금 수행중인 작업의 이름
        System.out.println("현재 수행중인 "+coreMethod+"() 이후에 출력됨");
        if(obj instanceof MemberVO){
            MemberVO vo = (MemberVO) obj; // 다운캐스팅
            System.out.println("리턴된 객체는 "+vo+"입니다");
        }
        else if(obj instanceof BoardVO){
            BoardVO vo = (BoardVO) obj;
            System.out.println("리턴된 객체는 "+vo+"입니다");
        }
        else{
            System.out.println("캐스팅 불가한 객체");
        }
    }
    // 서블릿 컨테이너(톰캣)가 서블릿객체를 생성 -> 객체.doGet()

}
