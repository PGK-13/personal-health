package org.example.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@TableName("exercise_types")
@Data
public class ExerciseType {
    @TableId(type = IdType.AUTO)
    private Integer exerciseTypeId;
    private String typeName;
    private double unitCalorie;
    private String unitType;
}
