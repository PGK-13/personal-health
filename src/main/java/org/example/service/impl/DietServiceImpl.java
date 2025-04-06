package org.example.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.example.mapper.DietMapper;
import org.example.mapper.FoodItemMapper;
import org.example.pojo.dto.Code;
import org.example.pojo.dto.DietAddDTO;
import org.example.pojo.dto.DietDTO;
import org.example.pojo.entity.Diet;
import org.example.pojo.entity.FoodItem;
import org.example.pojo.result.Result;
import org.example.pojo.vo.DietVO;
import org.example.pojo.vo.ExerciseVO;
import org.example.service.DietService;
import org.example.utils.ThreadLocalUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Map;

/**
 * @param
 * @author zklee
 * @return
 * @date 2025/3/31
 */
@Service
public class DietServiceImpl implements DietService {
    @Autowired
    private DietMapper dietMapper;
    @Autowired
    private FoodItemMapper foodItemMapper;
    @Override
    public Result pageQuery(DietDTO dietDTO) {
        Map<String, Object> map = ThreadLocalUtil.get();
        Integer userid = (Integer) map.get("id");
        dietDTO.setUserId(userid);

        Page<DietVO> page = new Page<>(dietDTO.getPage(), dietDTO.getPageSize());
        IPage<DietVO> resultPage =  dietMapper.selectDietVOPage(page, dietDTO);
        return new Result(Code.GET_OK, resultPage, "查询成功");
    }

    @Override
    public Result add(DietAddDTO dietAddDTO) {
        Diet diet = new Diet();
        BeanUtils.copyProperties(dietAddDTO, diet);

        System.out.println(dietAddDTO.getQuantity());
        System.out.println(diet.getQuantity());

        Map<String, Object> map = ThreadLocalUtil.get();
        Integer userid = (Integer) map.get("id");
        diet.setUserId(userid);
        // TODO 如果用户传入吃饭时间，则修改DTO类，并更换为用户传入时间
        diet.setRecordedAt(LocalDateTime.now());

        QueryWrapper<FoodItem> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("food_name", dietAddDTO.getFoodName());
        FoodItem foodItem = foodItemMapper.selectOne(queryWrapper);
        diet.setFoodId(foodItem.getFoodId());
        diet.setCalories(foodItem.getCaloriePerUnit() * diet.getQuantity());
        dietMapper.insert(diet);
        return new Result(Code.SAVE_OK, diet, "新增成功");
    }
}
