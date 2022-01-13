package com.lee.common;

class A{
    void func(){
        System.out.println("A에서 출력");
    }
}

class B extends A{
    @Override
    void func(){
        System.out.println("B에서 출력");
    }
}

class C extends A{
    @Override
    void func(){
        System.out.println("C에서 출력");
    }
}

public class Test {
    public static void main(String[] args) {
//        OOP특징: 추상화 상속 다형성 캡슐화 정보은닉
//         오버라이딩을 통하여 다형성 실현 -> 오버라이딩된 메서드가 자동으로 호출되는 것 -> 동적 바인딩
        A[] data = new A[2];
        data[0] = new B(); // 업 캐스팅         A data = new B(); 와 같다
        data[1] = new C();
        for (A datum : data) {
            datum.func();
        }
    }
}
