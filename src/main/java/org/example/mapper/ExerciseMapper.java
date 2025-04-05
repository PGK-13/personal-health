package org.example.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.example.pojo.dto.ExerciseDTO;
import org.example.pojo.entity.Exercise;
import org.example.pojo.vo.ExerciseVO;

@Mapper
public interface ExerciseMapper extends BaseMapper<Exercise> {

    IPage<ExerciseVO> selectExerciseVOPage(Page<ExerciseVO> page, @Param("dto") ExerciseDTO dto);
}
