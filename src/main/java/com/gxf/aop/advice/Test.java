package com.gxf.aop.advice;

import org.springframework.aop.framework.ProxyFactory;

/**
 * @Author: <guanxianseng@163.com>
 * @Description:
 * @Date: Created in : 2018/12/24 9:00 PM
 **/
public class Test {
  public static void main(String[] arg){
    Service service=new ServiceImpl();//
    //使用代理工厂为目标对象创建代理，并织入我们自己的advice逻辑
    ProxyFactory proxyFactoryBean=new ProxyFactory();
    proxyFactoryBean.setTarget(service);//设置目标对象
    proxyFactoryBean.addAdvice(new BeforeAdvice());//为目标对象织入增强
    proxyFactoryBean.addAdvice(new AfterAdvice());
    proxyFactoryBean.addAdvice(new RoundAdvice());
    Service proxy=(Service)proxyFactoryBean.getProxy();
    proxy.print("test");
  }
}
