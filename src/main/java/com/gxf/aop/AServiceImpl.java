package com.gxf.aop;

/**
 * @Author: <guanxianseng@163.com>
 * @Description:
 * @Date: Created in : 2018/12/23 2:46 PM
 **/
public class AServiceImpl implements AService {
  public void barA() {
    System.out.println("AServiceImpl.barA()");
  }

  public void fooA(String _msg) {
    System.out.println("AServiceImpl.fooA(msg:" + _msg + ")");
  }

}
