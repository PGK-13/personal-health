package org.example.service;

import org.example.pojo.dto.ReminderDTO;
import org.example.pojo.result.Result;

/**
 * @param
 * @author zklee
 * @return
 * @date 2025/4/1
 */
public interface ReminderService {

    Result list(int currentPage);

    Result add(ReminderDTO reminderDTO);
}
