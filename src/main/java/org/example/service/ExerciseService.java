package org.example.service;

import org.example.pojo.dto.ExerciseDTO;
import org.example.pojo.result.Result;
import org.example.pojo.entity.Exercise;

public interface ExerciseService {
    public Result add(ExerciseDTO exerciseDTO);

    public Result pageQuery(ExerciseDTO exerciseDTO);
}
