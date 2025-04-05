package org.example.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.example.mapper.GoalMapper;
import org.example.pojo.dto.Code;
import org.example.pojo.dto.GoalDTO;
import org.example.pojo.entity.Goal;
import org.example.pojo.result.Result;
import org.example.service.GoalService;
import org.example.utils.ThreadLocalUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Map;

/**
 * @param
 * @author zklee
 * @return
 * @date 2025/4/1
 */
@Service
public class GoalServiceImpl implements GoalService {
    @Autowired
    private GoalMapper goalMapper;

    @Override
    public Result list(int currentPage) {
        QueryWrapper<Goal> queryWrapper = new QueryWrapper<>();

        Page<Goal> page = new Page<>(currentPage, 10);
        Page<Goal> resultPage =  goalMapper.selectPage(page, queryWrapper);

        return new Result(Code.GET_OK, resultPage, "查询成功");
    }

    @Override
    public Result add(GoalDTO goalDTO) {
        Goal goal = new Goal();
        BeanUtils.copyProperties(goalDTO, goal);

        goal.setStartDate(LocalDate.now());

        Map<String, Object> map = ThreadLocalUtil.get();
        Integer userid = (Integer) map.get("id");
        goal.setUserId(userid);

        // TODO 查询个人体征，计算出progress
        goalMapper.insert(goal);
        return new Result(Code.SAVE_OK, null, "插入成功");
    }
}
