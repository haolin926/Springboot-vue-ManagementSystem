package com.springbootdemo.mapper;


import com.springbootdemo.entity.Emp;
import org.apache.ibatis.annotations.*;

import java.util.List;


@Mapper
public interface EmpMapper {

    @Insert("INSERT INTO employee (name,age,gender,address) VALUES" +
            " (#{name},#{age},#{gender},#{address})")
    void save(Emp emp);


    @Select("SELECT * " +
            "FROM employee " +
            "WHERE name LIKE concat('%',#{name},'%') ")
    List<Emp> list(String search);


    void update(Emp emp);

    @Delete("DELETE FROM employee WHERE id = #{id}")
    void delete(Long id);
}

