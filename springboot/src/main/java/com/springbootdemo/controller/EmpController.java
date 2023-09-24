package com.springbootdemo.controller;


import com.springbootdemo.common.Result;
import com.springbootdemo.entity.Dept;
import com.springbootdemo.entity.Emp;
import com.springbootdemo.entity.PageBean;
import com.springbootdemo.service.DeptService;
import com.springbootdemo.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emp")
public class EmpController {
    @Autowired
    private EmpService empService;

    @Autowired
    private DeptService deptService;

    @PostMapping("/save")
    public Result<?> save(@RequestBody Emp emp)
    {
        empService.save(emp);

        Dept dept = deptService.selectById(emp.getDeptId());
        dept.setNumEmp(dept.getNumEmp() + 1);
        deptService.update(dept);

        return Result.success();
    }

    @GetMapping("/dept")
    public Result<?> listAllDept()
    {
         List<Dept> deptList = deptService.getDepts();

        return Result.success(deptList);
    }

    @GetMapping
    public Result<?> findPage(@RequestParam(defaultValue = "1") Integer pageNum,
                             @RequestParam(defaultValue = "5") Integer pageSize,
                             @RequestParam(defaultValue = "") String search)
    {
        PageBean pageBean = empService.page(pageNum, pageSize, search);

        return Result.success(pageBean);
    }

    @PutMapping("/update")
    public Result<?> update(@RequestBody Emp emp)
    {
        empService.update(emp);
        return Result.success();
    }

    @DeleteMapping("/{id}")
    public Result<?> delete(@PathVariable Long id)
    {
        empService.delete(id);
        return Result.success();
    }

}
