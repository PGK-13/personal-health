package org.example.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.example.mapper.ExerciseMapper;
import org.example.mapper.ExerciseTypeMapper;
import org.example.pojo.dto.Code;
import org.example.pojo.dto.ExerciseAddDTO;
import org.example.pojo.dto.ExerciseDTO;
import org.example.pojo.entity.ExerciseType;
import org.example.pojo.result.Result;
import org.example.pojo.entity.Exercise;
import org.example.pojo.vo.ExerciseVO;
import org.example.service.ExerciseService;
import org.example.utils.ThreadLocalUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Map;

@Service
public class ExerciseServiceImpl implements ExerciseService {

    @Autowired
    private ExerciseMapper exerciseMapper;
    @Autowired
    private ExerciseTypeMapper exerciseTypeMapper;

    @Override
    public Result add(ExerciseAddDTO exerciseAddDTO) {
        Exercise exercise = new Exercise();
        BeanUtils.copyProperties(exerciseAddDTO, exercise);

        Map<String, Object> map = ThreadLocalUtil.get();
        Integer userid = (Integer) map.get("id");
        exercise.setUserId(userid);
        exercise.setRecordedAt(LocalDateTime.now());

        QueryWrapper<ExerciseType> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("type_name", exerciseAddDTO.getTypeName());
        ExerciseType exerciseType = exerciseTypeMapper.selectOne(queryWrapper);
        exercise.setExerciseTypeId(exerciseType.getExerciseTypeId());

        // TODO 计算卡路里

        exerciseMapper.insert(exercise);
        return new Result(Code.SAVE_OK, exercise, "新增成功");
    }

    @Override
    public Result pageQuery(ExerciseDTO exerciseDTO) {
        Page<ExerciseVO> page = new Page<>(exerciseDTO.getPage(), exerciseDTO.getPageSize());
        IPage<ExerciseVO> resultPage =  exerciseMapper.selectExerciseVOPage(page, exerciseDTO);
        return new Result(Code.GET_OK, resultPage, "查询成功");
    }
}
