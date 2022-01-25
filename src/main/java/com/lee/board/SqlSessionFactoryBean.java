package com.lee.board;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

public class SqlSessionFactoryBean {
    private static SqlSessionFactory sessionFactory=null;
    // "객체와 무관하게"
    static {
        Reader reader = null;
        try {
            if(sessionFactory == null){
                reader = Resources.getResourceAsReader("sql-map-config.xml");
                sessionFactory = new SqlSessionFactoryBuilder().build(reader);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static SqlSession getSqlSessionInstance(){
        return sessionFactory.openSession();
    }
}
