//package com.lee.common;
//
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.servlet.ModelAndView;
//
//@ControllerAdvice("com.lee") // 해당 경로에서 예외가 발생하면 올수 있도록 설정
//public class CommonExceptionHandler {
//    @ExceptionHandler(NullPointerException.class)
//    public ModelAndView excep1(Exception e){
//        ModelAndView mav = new ModelAndView();
//        mav.addObject("exception", e);
//        mav.setViewName("errors/error.jsp");
//        return mav;
//    }
//
//    @ExceptionHandler(IllegalArgumentException.class)
//    public ModelAndView excep2(Exception e){
//        ModelAndView mav = new ModelAndView();
//        mav.addObject("exception", e);
//        mav.setViewName("errors/errorId.jsp");
//        return mav;
//    }
//    public void excep3(){
//
//    }
//}
