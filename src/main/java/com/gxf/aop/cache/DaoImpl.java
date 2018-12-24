package com.gxf.aop.cache;

/**
 * @Author: <guanxianseng@163.com>
 * @Description:
 * @Date: Created in : 2018/12/24 11:40 PM
 **/
public class DaoImpl
{
  public String query(int id)
  {
    // 模拟耗时的数据库查询操作
    try
    {
      System.out.println("query begin...");
      Thread.sleep(100 * id);
      System.out.println("query over...");
    } catch (InterruptedException e)
    {
      e.printStackTrace();
    }

    return "result:" + id * 10;
  }

}
