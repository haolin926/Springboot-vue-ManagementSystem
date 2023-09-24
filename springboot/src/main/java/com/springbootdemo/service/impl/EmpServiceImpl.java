package com.springbootdemo.service.impl;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.springbootdemo.entity.Emp;

import com.springbootdemo.entity.PageBean;
import com.springbootdemo.mapper.DeptMapper;
import com.springbootdemo.mapper.EmpMapper;
import com.springbootdemo.service.DeptService;
import com.springbootdemo.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * (User)表服务实现类
 *
 * @author makejava
 * @since 2023-09-22 23:19:28
 */
@Service
public class EmpServiceImpl implements EmpService {
    @Autowired
    private EmpMapper empMapper;

    @Autowired
    private DeptMapper deptMapper;

    @Override
    public void save(Emp emp) {
        empMapper.save(emp);
    }

    @Override
    public PageBean page(Integer pageNum, Integer pageSize, String search) {
        PageHelper.startPage(pageNum,pageSize);

        List<Emp> e = empMapper.list(search);
        Page<Emp> p = (Page<Emp>) e;

        return new PageBean(p.getTotal(),p.getResult());
    }

    @Override
    public void update(Emp emp) {
        empMapper.update(emp);
    }

    @Override
    public void delete(Long id) {
        empMapper.delete(id);
    }
}
