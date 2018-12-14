package com.gxf.mybatis.jdk.bean;

/**
 * @Author: <guanxianseng@163.com>
 * @Description:
 * @Date: Created in : 2018/12/14 7:50 AM
 **/
public class Price {
  private String mBuyPrice;

  public String getMBuyPrice() {
    return mBuyPrice;
  }

  public void setMBuyPrice(String mBuyPrice) {
    this.mBuyPrice = mBuyPrice;
  }

  @Override
  public String toString() {
    return "Price{" +
        "mBuyPrice='" + mBuyPrice + '\'' +
        '}';
  }
}