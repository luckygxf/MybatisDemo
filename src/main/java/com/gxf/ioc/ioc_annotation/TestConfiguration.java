package com.gxf.ioc.ioc_annotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Author: <guanxianseng@163.com>
 * @Description:
 * @Date: Created in : 2018/12/14 8:59 PM
 **/
//@Configuration
@ComponentScan(basePackages = "com.gxf.ioc.ioc_annotation")
public class TestConfiguration {
//  String name;

  public TestConfiguration(){
//    name = "spring ioc";
    System.out.println("spring容器启动初始化。。。");
  }

  //@Bean注解注册bean,同时可以指定初始化和销毁方法
  //@Bean(name="testNean",initMethod="start",destroyMethod="cleanUp")
  @Bean
//  @Conditional(MagicExistCondition.class)
//  @Scope("prototype")
  public TestBean testBean() {
    return new TestBean("guaxiangfie");
  }


//  @Override
//  public String toString() {
//    return "TestConfiguration{" +
//        "name='" + name + '\'' +
//        '}';
//  }
}