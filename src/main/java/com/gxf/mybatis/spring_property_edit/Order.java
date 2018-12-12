package com.gxf.mybatis.spring_property_edit;

import java.util.Date;

/**
 * @Author: <guanxiangfei@meituan.com>
 * @Description:
 * @Date: Created in : 2018/12/11 10:23 AM
 **/
public class Order {
  private Date createDate;

  public Date getCreateDate() {
    return createDate;
  }

  public void setCreateDate(Date createDate) {
    this.createDate = createDate;
  }

  @Override
  public String toString() {
    return "Order{" +
        "createDate=" + createDate +
        '}';
  }
}
