package com.gsh.controller;

import com.gsh.pojo.Emp;
import com.gsh.pojo.LoginInfo;
import com.gsh.pojo.Result;
import com.gsh.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
@Slf4j
public class LoginController {
    @Autowired
    private EmpService empService;

    @PostMapping
    public Result login(@RequestBody Emp emp) {
        log.info("登录:{}", emp);
        LoginInfo info = empService.login(emp);
        if (info != null) {
            return Result.success(info);
        }
        return Result.error("用户名或密码错误");
    }
}
