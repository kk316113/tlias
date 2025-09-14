package com.gsh.service;

import com.gsh.pojo.Emp;
import com.gsh.pojo.EmpQueryParam;
import com.gsh.pojo.LoginInfo;
import com.gsh.pojo.PageResult;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;

public interface EmpService {
    //    PageResult<Emp> page(Integer page, Integer pageSize, String name, Integer gender, LocalDate begin, LocalDate end);
    PageResult<Emp> page(EmpQueryParam empQueryParam);

    void save(Emp emp);

    void delete(Integer[] ids);

    Emp getInfo(Integer id);

    void update(Emp emp);

    List<Emp> listAll();

    LoginInfo login(Emp emp);
}
