package com.gxf.jdk;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: <guanxianseng@163.com>
 * @Description:
 * @Date: Created in : 2019/1/17 10:11 AM
 **/
public class TestHashCode {

  public static void main(String[] args) {
    Person zhangsan = new Person("zhangsan", 18);
    Person zhangsan1 = new Person("zhangsan", 18);
    Person lisi = new Person("lisi", 18);

    Map<Person, Integer> person2Age = new HashMap<>();
    person2Age.put(zhangsan, 18);
    System.out.println(person2Age.get(zhangsan));

    System.out.println(person2Age.get(zhangsan1));
    System.out.println(zhangsan  == zhangsan1);
  }


  static class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
      this.name = name;
      this.age = age;
    }

    public String getName() {
      return name;
    }

    public void setName(String name) {
      this.name = name;
    }

    public int getAge() {
      return age;
    }

    public void setAge(int age) {
      this.age = age;
    }

    @Override
    public boolean equals(Object obj) {
      if (this == obj)
        return true;
      if (!(obj instanceof Person))
        return false;
      if(((Person) obj).getName().equals(name) &&
          ((Person) obj).getAge() == age)
        return true;
      return false;
    }

    @Override
    public int hashCode() {
      return name.hashCode();
    }

    @Override
    public String toString() {
      return "Person{" +
          "name='" + name + '\'' +
          ", age=" + age +
          '}';
    }
  }

}
