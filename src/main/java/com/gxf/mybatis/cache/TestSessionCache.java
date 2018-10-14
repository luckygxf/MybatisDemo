package com.gxf.mybatis.cache;

import com.gxf.mybatis.beans.Student;
import com.gxf.mybatis.mapper.StudentMapper;
import com.gxf.mybatis.util.SqlSessionFactoryHelper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

/**
 * @Author: <guanxiangfei@meituan.com>
 * @Description:
 * @Date: Created in : 2018/10/12 下午9:18
 **/
public class TestSessionCache {
    private static SqlSessionFactory sqlSessionFactory = SqlSessionFactoryHelper.getSqlSessionFactory();

    public static void main(String[] args) {
//        insertExpireData();
        testLocalCacheScope();
    }

    /**
     * 两个sqlsession 缓存是否失效
     * */
    private static void testLocalCacheScope(){
        SqlSession sqlSession1 = sqlSessionFactory.openSession(true);
        SqlSession sqlSession2 = sqlSessionFactory.openSession(true);

        StudentMapper studentMapper = sqlSession1.getMapper(StudentMapper.class);
        StudentMapper studentMapper2 = sqlSession2.getMapper(StudentMapper.class);

        System.out.println("studentMapper读取数据: " + studentMapper.getStudentById(4));
        System.out.println("studentMapper读取数据: " + studentMapper.getStudentById(4));
        System.out.println("studentMapper2更新了" + studentMapper2.updateStudentName("小官",4) + "个学生的数据");
        System.out.println("studentMapper读取数据: " + studentMapper.getStudentById(4));
        System.out.println("studentMapper2读取数据: " + studentMapper2.getStudentById(4));
    }

    /**
     * 插入数据，使得缓存失效
     * */
    private static void insertExpireData(){
        SqlSession sqlSession = sqlSessionFactory.openSession(true); // 自动提交事务
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        System.out.println(studentMapper.getStudentById(1));
        System.out.println("增加了" + studentMapper.addStudent(buildStudent()) + "个学生");
        System.out.println(studentMapper.getStudentById(1));
        sqlSession.close();
    }

    /**
     * 多次查询使用cache
     * */
    private void testQueryUseCache(){
        SqlSession sqlSession = sqlSessionFactory.openSession(true); // 自动提交事务
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        System.out.println(studentMapper.getStudentById(4));
        System.out.println(studentMapper.getStudentById(4));
        System.out.println(studentMapper.getStudentById(4));
    }


    /**
     * 创建学生对象
     * */
    private static Student buildStudent(){
        Student student = new Student();
        student.setName("guanxianseng1");
        student.setAge(29);
        return student;
    }
}
