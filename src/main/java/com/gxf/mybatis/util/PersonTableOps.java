package com.gxf.mybatis.util;

import com.gxf.mybatis.mapper.PersonMapper;
import com.gxf.mybatis.mapper.PersonMapper1;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PersonTableOps {
    private static SqlSessionFactory sqlSessionFactory = SqlSessionFactoryHelper.getSqlSessionFactory();
    private static PersonMapper personMapper;

    public static void main(String[] args) {
        testSpringMybatis();
    }


    private static void testSpringMybatis(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        personMapper = (PersonMapper) applicationContext.getBean("personMapper");
        Person person = personMapper.selectPerson(1);
        System.out.println(person);
    }

    /**
     * test mybatis select method
     * */
    private static void testSelectOnes(){
        //        selectOne1();
//        selectOne2();
        selectOne3();
    }

    /**
     * 第一种方式
     * */
    public static void selectOne1(){
        SqlSession session = sqlSessionFactory.openSession();
        try {
            Person person = session.selectOne(
                    "com.gxf.mybatis.mapper.PersonMapper.selectPerson", 1);
            System.out.println(person);
        } finally {
            session.close();
        }
    }

    /**
     * 第二种方式
     * */
    public static void selectOne2(){
        SqlSession session = sqlSessionFactory.openSession();
        try {
            PersonMapper mapper = session.getMapper(PersonMapper.class);
            Person person = mapper.selectPerson(1);
            System.out.println(person);
        } finally {
            session.close();
        }

    }

    /**
     * 第三种方式
     * */
    public static void selectOne3(){
        SqlSession session = sqlSessionFactory.openSession();
        try {
            sqlSessionFactory.getConfiguration().addMapper(PersonMapper1.class);
            PersonMapper1 mapper = session.getMapper(PersonMapper1.class);
            Person person = mapper.selectPerson(1);
            System.out.println(person);
        } finally {
            session.close();
        }
    }

    public static SqlSessionFactory getSqlSessionFactory() {
        return sqlSessionFactory;
    }

    public static void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        PersonTableOps.sqlSessionFactory = sqlSessionFactory;
    }

    public PersonMapper getPersonMapper() {
        return personMapper;
    }

    public void setPersonMapper(PersonMapper personMapper) {
        this.personMapper = personMapper;
    }
}