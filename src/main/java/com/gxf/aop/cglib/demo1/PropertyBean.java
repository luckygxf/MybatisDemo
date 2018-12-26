package com.gxf.aop.cglib.demo1;

/**
 * @Author: <guanxiangfei@meituan.com>
 * @Description:
 * @Date: Created in : 2018/12/26 11:21 PM
 **/
public class PropertyBean {
  private String key;
  private Object value;
  public String getKey() {
    return key;
  }
  public void setKey(String key) {
    this.key = key;
  }
  public Object getValue() {
    return value;
  }
  public void setValue(Object value) {
    this.value = value;
  }
  @Override
  public String toString() {
    return "PropertyBean [key=" + key + ", value=" + value + "]" +getClass();
  }


}
