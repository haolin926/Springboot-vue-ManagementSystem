package com.springbootdemo.mapper;

import com.springbootdemo.entity.Dept;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface DeptMapper {

    @Select("SELECT * FROM department WHERE department.dept_name LIKE concat('%',#{deptName},'%')")
    List<Dept> list(String search);

    @Insert("INSERT INTO department (dept_id, dept_name) VALUES (#{deptId},#{deptName})")
    void save(Dept dept);


    void update(Dept dept);

    @Delete("DELETE FROM department WHERE dept_id = #{deptId}")
    void delete(Long id);

    @Select("SELECT * FROM department WHERE dept_id = #{id}")
    Dept selectById(Integer id);

    @Select("SELECT * FROM department")
    List<Dept> list2();
}
