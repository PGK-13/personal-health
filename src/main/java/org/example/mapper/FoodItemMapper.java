package org.example.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.example.pojo.entity.FoodItem;

@Mapper
public interface FoodItemMapper extends BaseMapper<FoodItem> {
}
