package com.gsh.service;

import com.gsh.pojo.Clazz;
import com.gsh.pojo.ClazzQueryParam;
import com.gsh.pojo.PageResult;

public interface ClazzService {
    PageResult<Clazz> page(ClazzQueryParam clazzQueryParam);

    void deleteById(Integer id);

    void save(Clazz clazz);
}
