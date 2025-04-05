package org.example.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.example.pojo.entity.VitalSign;

@Mapper
public interface VitalSignDao extends BaseMapper<VitalSign> {
}
