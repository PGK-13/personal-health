package org.example.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDate;

/**
 * @param
 * @author zklee
 * @return
 * @date 2025/4/1
 */
@Data
@TableName("goals")
public class Goal {
    @TableId(type = IdType.AUTO)
    private Integer goalId;
    private Integer userId;
    private String targetType;
    private double targetValue;
    private LocalDate startDate;
    private LocalDate endDate;
    private double progress;
}
