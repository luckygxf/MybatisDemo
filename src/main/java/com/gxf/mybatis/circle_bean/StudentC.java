package com.gxf.mybatis.circle_bean;

/**
 * @Author: <guanxiangfei@meituan.com>
 * @Description:
 * @Date: Created in : 2018/12/10 11:11 PM
 **/
public class StudentC {
  private StudentA studentA ;

  public void setStudentA(StudentA studentA) {
    this.studentA = studentA;
  }

  public StudentC() {
  }

  public StudentC(StudentA studentA) {
    this.studentA = studentA;
  }

}
