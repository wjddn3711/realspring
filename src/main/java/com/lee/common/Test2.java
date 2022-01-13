package com.lee.common;

import java.util.Objects;

class Point{
    int x;
    int y;
    Point(int x, int y){
        this.x =x;
        this.y =y;
    }
    void move(){
        x++;
        y++;
    }

    @Override
    public boolean equals(Object o) {
        if(!(o instanceof Point)){
            return false;
        }
        Point point = (Point) o;
        if(x==point.x && y==point.y){
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}

public class Test2 {
    public static void main(String[] args) {
        Point p1 = new Point(10,20);
        Point p2 = new Point(9,19);
        p2.move();
        if(p1==p2){ // 비교연산자 xxx equals()
            System.out.println("같다");
        }
        else{
            System.out.println("다르다");
        }
    }
}
