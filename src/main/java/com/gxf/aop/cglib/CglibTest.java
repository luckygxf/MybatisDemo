package com.gxf.aop.cglib;

import org.springframework.cglib.proxy.Enhancer;

/**
 * @Author: <guanxianseng@163.com>
 * @Description:
 * @Date: Created in : 2018/12/25 4:52 PM
 **/
public class CglibTest {

  public static void main(String[] args) {
    DaoProxy daoProxy = new DaoProxy();

    Enhancer enhancer = new Enhancer();
    enhancer.setSuperclass(Dao.class);
    enhancer.setCallback(daoProxy);

    Dao dao = (Dao)enhancer.create();
    dao.update();
    dao.select();
  }
}
