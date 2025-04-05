package org.example.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @param
 * @author zklee
 * @return
 * @date 2025/3/31
 */
@Data
@TableName("Diet")
public class Diet {
    @TableId(type = IdType.AUTO)
    private Integer dietId;
    private Integer userID;
    private Integer foodId;
    private double quantity;
    private double calories;
    private LocalDateTime recordedAt;
}
