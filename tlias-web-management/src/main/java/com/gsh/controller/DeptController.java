package com.gsh.controller;

import com.gsh.anno.Log;
import com.gsh.pojo.Dept;
import com.gsh.pojo.Result;
import com.gsh.service.DeptService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@RequestMapping("/depts")
@RestController
public class DeptController {
    //    private static final Logger log= LoggerFactory.getLogger(DeptController.class);
    @Autowired
    private DeptService deptService;

    //    @RequestMapping(value = "/depts",method = RequestMethod.GET)
    @GetMapping
    public Result list() {
//        System.out.println("查询全部部门数据");
        log.info("查询全部部门数据");
        List<Dept> deptlist = deptService.findAll();
        return Result.success(deptlist);
    }
    @Log
    @DeleteMapping
//    3
    public Result delete(Integer id) {
//        System.out.println("删除部门数据" + id);
        log.info("删除部门数据，id：{}", id);
        deptService.deleteById(id);
        return Result.success();
    }

    //2
//    public Result delete(@RequestParam("id") Integer deptId) {
//        System.out.println("删除部门数据" + deptId);
//        return Result.success();
//    }
    //1
//    public Result delete(HttpServletRequest request) {
//        String idStr = request.getParameter("id");
//        int id = Integer.parseInt(idStr);
//        System.out.println("删除部门数据" + id);
//        return Result.success();
//    }
    @Log
    @PostMapping
    public Result add(@RequestBody Dept dept) {
//        System.out.println("添加部门数据" + dept);
        log.info("添加部门数据:{}", dept);
        deptService.add(dept);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result getInfo(@PathVariable Integer id) {
//        System.out.println("根据id查询部门" + id);
        log.info("根据id查询部门：{}", id);
        Dept dept = deptService.getById(id);
        return Result.success(dept);
    }
    @Log
    @PutMapping
    public Result update(@RequestBody Dept dept) {
//        System.out.println("修改部门数据" + dept);
        log.info("修改部门数据:{}", dept);
        deptService.update(dept);
        return Result.success();
    }
}
