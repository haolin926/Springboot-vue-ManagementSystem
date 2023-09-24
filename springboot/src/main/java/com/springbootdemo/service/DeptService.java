package com.springbootdemo.service;

import com.springbootdemo.entity.Dept;
import com.springbootdemo.entity.Emp;
import com.springbootdemo.entity.PageBean;

import java.util.List;

public interface DeptService {

    PageBean page(Integer pageNum, Integer pageSize, String search);

    void save(Dept dept);

    void update(Dept dept);

    void delete(Long id);

    Dept selectById(Integer id);

    List<Dept> getDepts();
}
