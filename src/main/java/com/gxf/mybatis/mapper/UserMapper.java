package com.gxf.mybatis.mapper;

import com.gxf.mybatis.beans.User;

import java.util.List;

/**
 * @Author:
 * @Description:
 * @Date: Created in : 2018/10/14 下午9:58
 **/
public interface UserMapper {

    User getById(String id);

    List<User> queryForList();
}
