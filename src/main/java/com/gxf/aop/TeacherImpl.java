package com.gxf.aop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author: <guanxianseng@163.com>
 * @Description:
 * @Date: Created in : 2018/12/23 3:16 PM
 **/
public class TeacherImpl implements Teacher {
  private static Logger logger = LoggerFactory.getLogger(TeacherImpl.class);

  @Override
  public void teach() {
    System.out.println("教师开始教课");
  }

  @Override
  public void teach(String name){
    logger.info("教师开始教课，课程名称: {}", name);
  }
}
