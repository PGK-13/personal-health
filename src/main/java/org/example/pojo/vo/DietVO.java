package org.example.pojo.vo;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @param
 * @author zklee
 * @return
 * @date 2025/3/31
 */
@Data
public class DietVO {
    private String foodName;
    private String unit;
    private double quantity;
    private double calories;
    private LocalDateTime recordedAt;
}
