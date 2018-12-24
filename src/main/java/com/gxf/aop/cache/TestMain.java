package com.gxf.aop.cache;

/**
 * @Author: <guanxianseng@163.com>
 * @Description:
 * @Date: Created in : 2018/12/24 11:42 PM
 **/

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMain
{
  private static ClassPathXmlApplicationContext context =
      new ClassPathXmlApplicationContext("classpath:spring_aop/spring_cache.xml");

  public static void main(String[] args)
  {
    for (int i = 0; i < 3; i++)
    {
      testDao();
    }
  }

  public static void testDao()
  {
    DaoImpl dao = (DaoImpl) context.getBean("dao");

    long begin = System.currentTimeMillis();
    String result = dao.query(2);
    long end = System.currentTimeMillis();

    System.out.println(result + ",cost time:" + (end - begin));
  }

}
