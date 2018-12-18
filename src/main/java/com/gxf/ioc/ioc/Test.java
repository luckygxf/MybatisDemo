package com.gxf.ioc.ioc;

import com.gxf.ioc.aware.HelloBean;
import com.gxf.ioc.ioc_annotation.PersonBean;
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
    ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
        "spring_ioc/mytestbeans.xml");
    PersonBean personBean =  applicationContext.getBean(PersonBean.class);
    System.out.println("personBean: " + personBean);

//    System.out.println("start spring context");
//    MyTestBean myTestBean = applicationContext.getBean(MyTestBean.class);
//    System.out.println("myTestBean: " + myTestBean);
//    TestBean testBean = applicationContext.getBean(TestBean.class);
//    System.out.println("testBean: " + testBean);
//    MagicExistCondition magicExistCondition = applicationContext.getBean(MagicExistCondition.class);
//    System.out.println("magicExistCondition: " + magicExistCondition);
  }

  private static void testAware(){
    ApplicationContext context = new ClassPathXmlApplicationContext("spring_ioc/mytestbeans.xml");

    HelloBean hello = (HelloBean) context.getBean("helloBean");
    System.out.println(hello.getHelloWord());
  }

}
