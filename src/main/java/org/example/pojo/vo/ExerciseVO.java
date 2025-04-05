package org.example.pojo.vo;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @param
 * @author zklee
 * @return
 * @date 2025/3/28
 */
@Data
public class ExerciseVO {
    private Integer exerciseId;
    private Integer exerciseTypeId;
    private String typeName;
    private double unitCalorie;
    private String unitType;
    private double value;
    private double calories;
    private LocalDateTime recordedAt;
}
