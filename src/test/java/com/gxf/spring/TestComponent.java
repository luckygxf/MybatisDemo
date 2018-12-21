package com.gxf.spring;

import org.junit.Test;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @Author: <guanxianseng@163.com>
 * @Description:
 * @Date: Created in : 2018/12/16 9:12 PM
 **/
public class TestComponent {

  @Test
  public void test1(){
    Service service = null;
    System.out.println(service instanceof Component);
  }
}
