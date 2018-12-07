package com.gxf.mybatis.beans;

import com.alibaba.fastjson.JSON;

import com.gxf.mybatis.annotations.GxfBean;
import java.io.Serializable;

/**
 * @Author:
 * @Description:
 * @Date: Created in : 2018/10/14 下午9:52
 **/
@GxfBean
public class Role implements Serializable {
    private String id;
    private String name;
    private String userId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
