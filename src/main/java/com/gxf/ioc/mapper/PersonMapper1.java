package com.gxf.ioc.mapper;

import com.gxf.ioc.util.Person;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

public interface PersonMapper1 {
    @Select("SELECT * FROM person WHERE id = #{ idss }")
//    @Results(
//            @Result(column = "home_address", property = "homeAddress")
//    )
    Person selectPerson(int idss);

    @Insert("INSERT INTO person(id, age, name, home_address) values(#{id}, #{age}, #{name}, #{homeAddress})")
    void save(Person person);
}
