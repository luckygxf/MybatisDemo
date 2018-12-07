package com.gxf.mybatis.beans;

import com.alibaba.fastjson.JSON;

import com.gxf.mybatis.annotations.GxfBean;
import java.io.Serializable;

/**
 * @Author:
 * @Description:
 * @Date: Created in : 2018/10/12 下午9:15
 **/
@GxfBean
public class Student implements Serializable {

    private int id;
    private String name;
    private int age;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
    public String toString() {
        return JSON.toJSONString(this);
    }
}
