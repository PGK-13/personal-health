package org.example.pojo.dto;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @param
 * @author zklee
 * @return
 * @date 2025/4/5
 */
@Data
public class ExerciseAddDTO {
    private String typeName;

    private double value;

    private LocalDateTime recordedAt;
}
