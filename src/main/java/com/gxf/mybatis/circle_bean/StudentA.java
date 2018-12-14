package com.gxf.mybatis.circle_bean;

/**
 * @Author: <guanxianseng@163.com>
 * @Description:
 * @Date: Created in : 2018/12/10 11:10 PM
 **/
public class StudentA {
  private StudentB studentB ;

  public void setStudentB(StudentB studentB) {
    this.studentB = studentB;
  }

  public StudentA() {
  }

  public StudentA(StudentB studentB) {
    this.studentB = studentB;
  }
}
