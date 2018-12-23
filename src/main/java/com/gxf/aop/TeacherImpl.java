package com.gxf.aop;

/**
 * @Author: <guanxianseng@163.com>
 * @Description:
 * @Date: Created in : 2018/12/23 3:16 PM
 **/
public class TeacherImpl implements Teacher {

  @Override
  public void teach() {
    System.out.println("教师开始教课");
  }
}
