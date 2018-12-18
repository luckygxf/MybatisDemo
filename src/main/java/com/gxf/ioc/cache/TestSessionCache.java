package com.gxf.ioc.cache;

import com.gxf.ioc.beans.Student;
import com.gxf.ioc.mapper.StudentMapper;
import com.gxf.ioc.util.SqlSessionFactoryHelper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

/**
 * @Author:
 * @Description:
 * @Date: Created in : 2018/10/12 下午9:18
 **/
public class TestSessionCache {
    private static SqlSessionFactory sqlSessionFactory = SqlSessionFactoryHelper.getSqlSessionFactory();

    public static void main(String[] args) {
//        insertExpireData();
//        testLocalCacheScope();
//        testCacheWithoutCommitOrClose();
        testCacheWithUpdate();
    }

    /**
     * 测试二级缓存: 更新数据库，二级缓存是否会失效
     * */
    public static void testCacheWithUpdate(){
        SqlSession sqlSession1 = sqlSessionFactory.openSession(true);
        SqlSession sqlSession2 = sqlSessionFactory.openSession(true);
        SqlSession sqlSession3 = sqlSessionFactory.openSession(true);

        StudentMapper studentMapper = sqlSession1.getMapper(StudentMapper.class);
        StudentMapper studentMapper2 = sqlSession2.getMapper(StudentMapper.class);
        StudentMapper studentMapper3 = sqlSession3.getMapper(StudentMapper.class);

        System.out.println("studentMapper读取数据: " + studentMapper.getStudentById(1));
        sqlSession1.commit();
        System.out.println("studentMapper2读取数据: " + studentMapper2.getStudentById(1));

        studentMapper3.updateStudentName("方方",1);
        sqlSession3.commit();
        System.out.println("studentMapper2读取数据: " + studentMapper2.getStudentById(1));
    }

    /**
     * 测试二级缓存
     * */
    public static void testCacheWithoutCommitOrClose(){
        SqlSession sqlSession1 = sqlSessionFactory.openSession(true);
        SqlSession sqlSession2 = sqlSessionFactory.openSession(true);

        StudentMapper studentMapper = sqlSession1.getMapper(StudentMapper.class);
        StudentMapper studentMapper2 = sqlSession2.getMapper(StudentMapper.class);

        System.out.println("studentMapper读取数据: " + studentMapper.getStudentById(1));
        sqlSession1.commit();
        System.out.println("studentMapper2读取数据: " + studentMapper2.getStudentById(1));

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
