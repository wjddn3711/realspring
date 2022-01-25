package com.lee.board;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

public class SqlSessionFactoryBean { // static 을 사용하여 클래스만 있더라도 사용할 수 있도록 한다
    private static SqlSessionFactory sessionFactory=null;
    // "객체와 무관하게"
    static {
        try {
            if(sessionFactory == null){
                Reader reader = Resources.getResourceAsReader("sql-map-config.xml");
                sessionFactory = new SqlSessionFactoryBuilder().build(reader);
            }
        } catch (IOException e) { // file not found 예외가 발생했을때 catch 에 주로 걸린다
            e.printStackTrace();
        }
    }
    public static SqlSession getSqlSessionInstance(){
        return sessionFactory.openSession();
    }
}
