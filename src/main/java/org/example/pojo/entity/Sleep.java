package org.example.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

@TableName("sleep_records")
@Data
public class Sleep {
    @TableId(type = IdType.AUTO)
    private Integer sleepId;
    private Integer userId;
    private double duration;
    private double deepSleep;
    private Integer quality;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private LocalDateTime recordedAt;
}
