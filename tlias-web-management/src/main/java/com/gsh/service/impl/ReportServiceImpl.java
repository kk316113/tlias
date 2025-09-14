package com.gsh.service.impl;

import com.gsh.mapper.EmpMapper;
import com.gsh.pojo.JobOption;
import com.gsh.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ReportServiceImpl implements ReportService {
    @Autowired
    private EmpMapper empMapper;

    @Override
    public List<Map<String, Object>> getEmpGenderData() {
        return empMapper.countEmpGenderData();
    }

    @Override
    public JobOption getEmpJobData() {
        //调用mapper接口获取数据
        List<Map<String, Object>> list = empMapper.countEmpJobData();
        //组装结果并返回
        List<Object> jobList = list.stream().map(dataMap -> dataMap.get("pos")).toList();
        List<Object> dataList = list.stream().map(dataMap -> dataMap.get("num")).toList();
        return new JobOption(jobList, dataList);
    }
}
