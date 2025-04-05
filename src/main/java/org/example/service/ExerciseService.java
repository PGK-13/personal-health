package org.example.service;

import org.example.pojo.dto.ExerciseAddDTO;
import org.example.pojo.dto.ExerciseDTO;
import org.example.pojo.result.Result;
import org.example.pojo.entity.Exercise;

public interface ExerciseService {
    public Result add(ExerciseAddDTO exerciseAddDTO);

    public Result pageQuery(ExerciseDTO exerciseDTO);
}
