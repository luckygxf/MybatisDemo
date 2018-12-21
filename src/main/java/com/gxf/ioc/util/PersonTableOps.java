package com.gxf.ioc.util;

import com.gxf.ioc.beans.User;
import com.gxf.ioc.mapper.PersonMapper;
import com.gxf.ioc.mapper.PersonMapper1;
import com.gxf.ioc.mapper.UserMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class PersonTableOps {
    private static SqlSessionFactory sqlSessionFactory = SqlSessionFactoryHelper.getSqlSessionFactory();
    private static PersonMapper personMapper;

    public static void main(String[] args) {
        queryMutiTablesList();

    }


    /**
     * 多表查询 返回list
     * */
    private static void queryMutiTablesList(){
        SqlSession session = sqlSessionFactory.openSession();
        try {
            UserMapper userMapper = session.getMapper(UserMapper.class);
            List<User> userList = userMapper.queryForList();
            System.out.println(userList);
        } finally {
            session.close();
        }
    }

    /**
     * 多表查询
     * */
    private static void queryMultiTables(){
        SqlSession session = sqlSessionFactory.openSession();
        try {
            UserMapper userMapper = session.getMapper(UserMapper.class);
            User user = userMapper.getById("1");
            System.out.println(user);
        } finally {
            session.close();
        }
    }


    private static void testSpringMybatis(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
            "spring_ioc/beans.xml");
        personMapper = (PersonMapper) applicationContext.getBean("personMapper");
        Person person = personMapper.selectPerson(1);
        System.out.println(person);
    }

    /**
     * spring ioc select method
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
                    "com.gxf.ioc.mapper.PersonMapper.selectPerson", 1);
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

    /**
     * 向数据库插入数据
     * */
    public static void insertPerson(){
        Person person = new Person();
        person.setId(2);
        person.setAge(28);
        person.setName("guanxiangfei");
        person.setHomeAddress("beijing_chaoyang");
        SqlSession session = sqlSessionFactory.openSession();
        try {
            sqlSessionFactory.getConfiguration().addMapper(PersonMapper1.class);
            PersonMapper1 mapper = session.getMapper(PersonMapper1.class);
            mapper.save(person);
            System.out.println(person);
        } finally {
            session.commit();
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
