package org.example.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.example.pojo.entity.Goal;

/**
 * 
 * @param 
 * @return 
 * @author zklee
 * @date 2025/4/1
 */
@Mapper
public interface GoalMapper extends BaseMapper<Goal> {
}
