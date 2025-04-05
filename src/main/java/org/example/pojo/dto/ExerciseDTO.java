package org.example.pojo.dto;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @param
 * @author zklee
 * @return
 * @date 2025/3/28
 */
@Data
public class ExerciseDTO {
    private int page;

    private int pageSize;

    private Integer exerciseTypeId;

    private String typeName;

    private LocalDateTime recordedAt;
}
