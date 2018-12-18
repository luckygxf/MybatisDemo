package com.gxf.ioc.test_factory_bean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author: <guanxianseng@163.com>
 * @Description:
 * @Date: Created in : 2018/12/10 8:05 AM
 **/
public class Test {

  public static void main(String[] args) throws Exception {
    ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
        "spring_ioc/mytestbeans.xml");
    PersonFactoryBean personFactoryBean = (PersonFactoryBean) applicationContext.getBean("&person");
    System.out.println("personFactoryBean:" + personFactoryBean);
    System.out.println("personFactoryBean.getObject()" + personFactoryBean.getObject());
    Person person = (Person) applicationContext.getBean("person");
    System.out.println(person);
  }
}
