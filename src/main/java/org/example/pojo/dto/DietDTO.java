package org.example.pojo.dto;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @param
 * @author zklee
 * @return
 * @date 2025/3/31
 */
@Data
public class DietDTO {
    private int page;

    private int pageSize;

    private LocalDateTime recordedAt;
}
