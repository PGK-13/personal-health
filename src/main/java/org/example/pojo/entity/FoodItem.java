package org.example.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@TableName("food_items")
@Data
public class FoodItem {
    @TableId(type = IdType.AUTO)
    private Integer foodId;
    private String foodName;
    private double caloriePerUnit;
    private String unit;
}
