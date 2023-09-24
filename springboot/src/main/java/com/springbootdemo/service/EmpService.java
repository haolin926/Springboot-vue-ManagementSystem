package com.springbootdemo.service;


import com.springbootdemo.entity.Emp;
import com.springbootdemo.entity.PageBean;

/**
 * (User)表服务接口
 *
 * @author makejava
 * @since 2023-09-22 23:16:04
 */
public interface EmpService {

    void save(Emp emp);

    PageBean page(Integer pageNum, Integer pageSize, String search);

    void update(Emp emp);

    void delete(Long id);
}
