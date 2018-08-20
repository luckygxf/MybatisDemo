package com.gxf.mybatis.mapper;

import com.gxf.mybatis.util.Person;
import org.apache.ibatis.annotations.Select;

public interface PersonMapper1 {
    @Select("SELECT * FROM person WHERE id = #{idss}")
    Person selectPerson(int idss);
}
