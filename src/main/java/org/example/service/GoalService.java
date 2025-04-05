package org.example.service;

import org.example.pojo.dto.GoalDTO;
import org.example.pojo.result.Result;

/**
 * @param
 * @author zklee
 * @return
 * @date 2025/4/1
 */
public interface GoalService {
    public Result list(int currentPage);
    public Result add(GoalDTO goalDTO);
}
