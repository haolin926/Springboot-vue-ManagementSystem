package com.springbootdemo.controller;


import com.springbootdemo.common.Result;
import com.springbootdemo.entity.Dept;
import com.springbootdemo.entity.Emp;
import com.springbootdemo.entity.PageBean;
import com.springbootdemo.service.DeptService;
import com.springbootdemo.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dept")
public class DeptController {
    @Autowired
    private DeptService deptService;


    @GetMapping
    public Result<?> findPage(@RequestParam(defaultValue = "1") Integer pageNum,
                              @RequestParam(defaultValue = "5") Integer pageSize,
                              @RequestParam(defaultValue = "") String search)
    {
        PageBean pageBean = deptService.page(pageNum, pageSize, search);

        return Result.success(pageBean);
    }
    @PostMapping("/save")
    public Result<?> save(@RequestBody Dept dept)
    {
        deptService.save(dept);
        return Result.success();
    }

    @PutMapping("/update")
    public Result<?> update(@RequestBody Dept dept)
    {
        deptService.update(dept);
        return Result.success();
    }

    @DeleteMapping("/{id}")
    public Result<?> delete(@PathVariable Long id)
    {
        deptService.delete(id);
        return Result.success();
    }

}
