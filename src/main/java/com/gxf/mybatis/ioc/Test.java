package com.gxf.mybatis.ioc;

import com.gxf.mybatis.aware.HelloBean;
import com.gxf.mybatis.ioc_annotation.PersonBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author: <guanxianseng@163.com>
 * @Description:
 * @Date: Created in : 2018/12/7 5:53 PM
 **/
public class Test {

  public static void main(String[] args) {
    testIoc1();
  }

  private static void testIoc1(){
    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("mytestbeans.xml");
    PersonBean personBean = (PersonBean) applicationContext.getBean(PersonBean.class);
    System.out.println(personBean);

    System.out.println("start spring context");
    MyTestBean myTestBean = applicationContext.getBean(MyTestBean.class);
    System.out.println(myTestBean);
  }

  private static void testAware(){
    ApplicationContext context = new ClassPathXmlApplicationContext("mytestbeans.xml");

    HelloBean hello = (HelloBean) context.getBean("helloBean");
    System.out.println(hello.getHelloWord());
  }

}
