package com.gxf.aop.cglib;

/**
 * @Author: <guanxianseng@163.com>
 * @Description:
 * @Date: Created in : 2018/12/25 4:51 PM
 **/
public class Dao {

  public void update() {
    System.out.println("PeopleDao.update()");
  }

  public void select() {
    System.out.println("PeopleDao.select()");
  }
}