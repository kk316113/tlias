package com.gsh.controller;

import com.gsh.pojo.JobOption;
import com.gsh.pojo.Result;
import com.gsh.service.ReportService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/report")
public class ReportController {

    @Autowired
    private ReportService reportService;
    @GetMapping("/empJobData")
    public Result getEmpJobData()
    {
        log.info("统计员工职位人数");
        JobOption JobOption =reportService.getEmpJobData();
        return Result.success(JobOption);
    }
    @GetMapping("/empGenderData")
    public Result getEmpGenderData()
    {
        log.info("统计员工性别人数");
        List<Map<String, Object>> genderList =reportService.getEmpGenderData();
        return Result.success(genderList);
    }

}
