package com.gxf.mybatis.test_factory_bean;

import org.springframework.beans.factory.FactoryBean;

/**
 * @Author: <guanxianseng@163.com>
 * @Description:
 * @Date: Created in : 2018/12/10 8:02 AM
 **/
public class PersonFactoryBean implements FactoryBean<Person> {
  private String personInfo;

  public Person getObject() throws Exception {
    Person person = new Person();
    String[] personInfos = personInfo.split(",");
    person.setName(personInfos[0]);
    person.setAge(Integer.parseInt(personInfos[1]));
    person.setCity(personInfos[2]);
    return person;
  }

  public Class<?> getObjectType() {
    return Person.class;
  }

  public boolean isSingleton() {
    return true;
  }

  public String getPersonInfo() {
    return personInfo;
  }

  public void setPersonInfo(String personInfo) {
    this.personInfo = personInfo;
  }
}
