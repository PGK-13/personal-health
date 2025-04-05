package org.example.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.example.mapper.ExerciseTypeMapper;
import org.example.pojo.dto.Code;
import org.example.pojo.result.Result;
import org.example.pojo.entity.ExerciseType;
import org.example.service.ExerciseTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExerciseTypeServiceImpl implements ExerciseTypeService {
    @Autowired
    private ExerciseTypeMapper exerciseTypeMapper;

    @Override
    public Result list(int currentPage) {
        QueryWrapper<ExerciseType> queryWrapper = new QueryWrapper<>();

        Page<ExerciseType> page = new Page<>(currentPage, 10);
        Page<ExerciseType> resultPage =  exerciseTypeMapper.selectPage(page, queryWrapper);

        return new Result(Code.GET_OK, resultPage, "查询成功");
    }

    @Override
    public ExerciseType getById(Integer id) {
        return exerciseTypeMapper.selectById(id);
    }
}
