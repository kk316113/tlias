package com.gsh.service;

import com.gsh.pojo.Dept;

import java.util.List;

public interface DeptService {
    List<Dept> findAll();

    void deleteById(Integer id);

    void add(Dept dept);

    void update(Dept dept);

    Dept getById(Integer id);
}
