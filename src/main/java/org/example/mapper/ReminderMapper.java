package org.example.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.example.pojo.entity.Reminder;

/**
 * @param
 * @author zklee
 * @return
 * @date 2025/4/1
 */
@Mapper
public interface ReminderMapper extends BaseMapper<Reminder> {
}
