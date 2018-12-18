package com.gxf.ioc.jdk;

import java.util.Formatter;

/**
 * @Author: <guanxianseng@163.com>
 * @Description:
 * @Date: Created in : 2018/12/10 3:35 PM
 **/
public class FormatTest {

  public static void main(String[] args) {
    String date = "7时15分";
    int orderNum = 18;
    double iph = 31.2497;
    double tph = 1.1034;

    String date1 = "0时0分";
    int orderNum1 = 0;
    double iph1 = 0.0;
    double tph1 = 0;
    print(date, orderNum, iph, tph);
    print(date1, orderNum1, iph1, tph1);

  }
  private static void print(String date, int orderNum, double iph, double tph){
    try(Formatter formatter = new Formatter()){
      System.out.println(date.length());
      String s = formatter.format("%-60.0s | %2d（单） |  %8.2f（元） | %6.2f（单）", date, orderNum, iph, tph).toString();
      System.out.println(s);
    }catch (Exception e){
      e.printStackTrace();
    }
  }
}
