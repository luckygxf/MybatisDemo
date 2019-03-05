package com.gxf.aop.aop_annotation1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @Author: <guanxianseng@163.com>
 * @Description:
 * @Date: Created in : 2019/1/22 2:15 PM
 **/
@Configuration
//启动AspectJ自动代理
@EnableAspectJAutoProxy
@ComponentScan
public class ConcertConfig {

  /**
   * 声明Audience bean
   * @return
   */
  @Bean
  public Audience audience(){
    return new Audience();
  }

}