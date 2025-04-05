package org.example.pojo.dto;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @param
 * @author zklee
 * @return
 * @date 2025/4/1
 */
@Data
public class ReminderDTO {
    private LocalDateTime triggerTime;
    private String type;
    private String detail;
}
