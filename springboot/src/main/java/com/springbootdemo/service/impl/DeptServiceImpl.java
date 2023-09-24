package com.springbootdemo.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.springbootdemo.entity.Dept;
import com.springbootdemo.entity.PageBean;
import com.springbootdemo.mapper.DeptMapper;
import com.springbootdemo.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {
    @Autowired
    private DeptMapper deptMapper;

    @Override
    public PageBean page(Integer pageNum, Integer pageSize, String search) {

        PageHelper.startPage(pageNum,pageSize);
        List<Dept> deptList = deptMapper.list(search);
        Page<Dept> p = (Page<Dept>) deptList;
        return new PageBean(p.getTotal(),p.getResult());
    }

    @Override
    public void save(Dept dept) {
        deptMapper.save(dept);
    }

    @Override
    public void update(Dept dept) {
        deptMapper.update(dept);
    }

    @Override
    public void delete(Long id) {
        deptMapper.delete(id);
    }

    @Override
    public Dept selectById(Integer id) {
        return deptMapper.selectById(id);
    }

    @Override
    public List<Dept> getDepts() {
        return deptMapper.list2();
    }
}
