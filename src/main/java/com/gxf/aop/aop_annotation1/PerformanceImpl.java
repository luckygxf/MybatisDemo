package com.gxf.aop.aop_annotation1;

import org.springframework.stereotype.Component;

/**
 * @Author: <guanxianseng@163.com>
 * @Description:
 * @Date: Created in : 2019/1/22 2:35 PM
 **/
@Component
public class PerformanceImpl implements Performance {

  @Override
  public void perform(Person performer, int order) throws  Exception{
    System.out.println("performer: " + performer + " start at order: " + order);
    throw new Exception("Performer throw exception");
  }
}