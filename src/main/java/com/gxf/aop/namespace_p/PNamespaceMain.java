package com.gxf.aop.namespace_p;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author: <guanxianseng@163.com>
 * @Description:
 * @Date: Created in : 2018/12/27 11:33 AM
 **/
public class PNamespaceMain {
  private static Logger logger = LoggerFactory.getLogger(PNamespaceMain.class);

  public static void main(String[] args) {
    ApplicationContext applicationContext =
        new ClassPathXmlApplicationContext("classpath:spring_aop/spring_namespace_p.xml");
    Hello hello1 = (Hello) applicationContext.getBean("hello1");
    logger.info("hello1:{}", hello1);
    Hello hello2 = (Hello) applicationContext.getBean("hello2");
    logger.info("hello2:{}", hello2);
    Hello hello3 = (Hello) applicationContext.getBean("hello3");
    logger.info("hello3:{}", hello3);
    Hello hello4 = (Hello) applicationContext.getBean("hello4");
    logger.info("hello4:{}", hello4);
  }
}
