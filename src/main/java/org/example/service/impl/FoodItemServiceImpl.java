package org.example.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.example.mapper.FoodItemMapper;
import org.example.pojo.dto.Code;
import org.example.pojo.result.Result;
import org.example.pojo.entity.FoodItem;
import org.example.service.FoodItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FoodItemServiceImpl implements FoodItemService {
    private static final Integer PAGESIZE = 10;

    @Autowired
    private FoodItemMapper foodItemMapper;

    @Override
    public Result list(int currentPage) {
        QueryWrapper<FoodItem> queryWrapper = new QueryWrapper<>();

        Page<FoodItem> page = new Page<>(currentPage, PAGESIZE);
        Page<FoodItem> resultPage =  foodItemMapper.selectPage(page, queryWrapper);

        return new Result(Code.GET_OK, resultPage, "查询成功");
    }

    @Override
    public Result add(FoodItem foodItem) {
        if (foodItem.getFoodName() != null) {
            QueryWrapper<FoodItem> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("food_name", foodItem.getFoodName());
            if (foodItemMapper.selectOne(queryWrapper) != null) {
                return new Result(Code.SAVE_ERR, "新增失败，已有此食物");
            }
        }
        int row = foodItemMapper.insert(foodItem);
        if (row > 0) {
            return new Result(Code.SAVE_OK, foodItem, "新增成功");
        } else {
            return new Result(Code.SAVE_ERR, "新增失败");
        }
    }

    @Override
    public Result update(FoodItem foodItem) {
        if (foodItem.getFoodName() != null) {
            QueryWrapper<FoodItem> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("food_name", foodItem.getFoodName());
            try{
                Integer id = foodItemMapper.selectOne(queryWrapper).getFoodId();
                foodItemMapper.updateById(foodItem);
                return new Result(Code.UPDATE_OK, foodItem, "修改成功");
            } catch (Exception e){
                System.out.println("无此食物");
            }
        }
        return new Result(Code.UPDATE_ERR, "修改失败");
    }

}
