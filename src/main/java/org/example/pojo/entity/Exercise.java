package org.example.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

@TableName("Exercise")
@Data
public class Exercise {
    @TableId(type = IdType.AUTO)
    private Integer exerciseId;
    private Integer userId;
    private Integer exerciseTypeId;
    private double value;
    private double calories;
    private LocalDateTime recordedAt;
}
