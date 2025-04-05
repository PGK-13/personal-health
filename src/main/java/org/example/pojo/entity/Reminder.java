package org.example.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.aopalliance.intercept.Interceptor;

import java.time.LocalDateTime;

/**
 * @param
 * @author zklee
 * @return
 * @date 2025/4/1
 */
@Data
@TableName("reminders")
public class Reminder {
    @TableId(type = IdType.AUTO)
    private Integer reminderId;
    private Integer userId;
    private String type;
    private String detail;
    private LocalDateTime triggerTime;
    private Integer status;
}
