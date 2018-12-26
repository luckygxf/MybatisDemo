package com.gxf.aop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author: <guanxianseng@163.com>
 * @Description:
 * @Date: Created in : 2018/12/23 2:50 PM
 **/
public class Main {
  private static Logger logger = LoggerFactory.getLogger(Main.class);

  public static void main(String[] args) {
    ApplicationContext applicationContext =
        new ClassPathXmlApplicationContext("classpath:spring_aop/spring_aop.xml");
//    AServiceImpl aService = (AServiceImpl) applicationContext.getBean("aService");
//    aService.barA();
//    BServiceImpl bService = applicationContext.getBean(BServiceImpl.class);
//    bService.fooB();
//    TestAspect testAspect = (TestAspect) applicationContext.getBean("TestAspect");

    Teacher teacher = (Teacher) applicationContext.getBean("teacherImpl");
    logger.info("teacher:{} teacher instanceof  Teacher:{}", teacher, teacher instanceof  Teacher);
//    teacher.teach();

    teacher.teach("Math");

  }
}
