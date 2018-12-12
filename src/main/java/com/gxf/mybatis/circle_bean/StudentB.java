package com.gxf.mybatis.circle_bean;

/**
 * @Author: <guanxiangfei@meituan.com>
 * @Description:
 * @Date: Created in : 2018/12/10 11:11 PM
 **/
public class StudentB {
  private StudentC studentC ;

  public void setStudentC(StudentC studentC) {
    this.studentC = studentC;
  }

  public StudentB() {
  }

  public StudentB(StudentC studentC) {
    this.studentC = studentC;
  }

}
