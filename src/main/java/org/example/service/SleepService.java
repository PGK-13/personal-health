package org.example.service;

import org.example.pojo.dto.SleepDTO;
import org.example.pojo.result.Result;
import org.example.pojo.entity.Sleep;

public interface SleepService {
    Result add(Sleep sleep);
    Result delete(Integer id);
    Result list(SleepDTO sleepDTO);
}
