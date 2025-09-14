package com.gsh.controller;

import com.gsh.pojo.Clazz;
import com.gsh.pojo.ClazzQueryParam;
import com.gsh.pojo.PageResult;
import com.gsh.pojo.Result;
import com.gsh.service.ClazzService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/clazzs")
public class ClazzController {

    @Autowired
    private ClazzService clazzService;

    //分页查询
    @GetMapping
    public Result page(ClazzQueryParam clazzQueryParam) {
        log.info("分页查询:{}", clazzQueryParam);
        PageResult<Clazz> pageResult = clazzService.page(clazzQueryParam);
        return Result.success(pageResult);
    }
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id){
        log.info("删除班级数据:{}",id);
        clazzService.deleteById(id);
        return Result.success();
    }
    @PostMapping
    public Result save(@RequestBody Clazz clazz){
        log.info("保存班级数据:{}",clazz);
        clazzService.save(clazz);
        return Result.success();
    }
}
