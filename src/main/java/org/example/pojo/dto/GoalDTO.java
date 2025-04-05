package org.example.pojo.dto;

import lombok.Data;

import java.time.LocalDate;

/**
 * @param
 * @author zklee
 * @return
 * @date 2025/4/1
 */
@Data
public class GoalDTO {
    private String targetType;

    private double targetValue;

    private LocalDate endDate;
}
