package org.example.service;

import org.example.pojo.entity.ExerciseType;
import org.example.pojo.result.Result;

public interface ExerciseTypeService {
    Result list(int currentPage);

    ExerciseType getById(Integer id);
}
