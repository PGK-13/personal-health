package org.example.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import org.example.pojo.dto.DietDTO;
import org.example.pojo.entity.Diet;
import org.example.pojo.vo.DietVO;
import org.example.pojo.vo.ExerciseVO;

/**
 * @param
 * @author zklee
 * @return
 * @date 2025/3/31
 */
public interface DietMapper extends BaseMapper<Diet> {

    IPage<DietVO> selectDietVOPage(Page<DietVO> page, @Param("dto") DietDTO dietDTO);
}
