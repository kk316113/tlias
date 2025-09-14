package com.gsh.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Clazz {
    private Integer id;// 班级id
    private String name;// 班级名称
    private String room;// 教室
    private LocalDate beginDate;// 开始时间
    private LocalDate endDate;// 结束时间
    private Integer masterId;// 班主任id
    private Integer subject;// 课程id
    private LocalDateTime createTime;// 创建时间
    private LocalDateTime updateTime;// 更新时间

    private String masterName;// 班主任名称
    private String status;// 状态
}
