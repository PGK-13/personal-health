package org.example.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.example.mapper.ReminderMapper;
import org.example.pojo.dto.Code;
import org.example.pojo.dto.ReminderDTO;
import org.example.pojo.entity.Reminder;
import org.example.pojo.result.Result;
import org.example.service.ReminderService;
import org.example.utils.ThreadLocalUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @param
 * @author zklee
 * @return
 * @date 2025/4/1
 */
@Service
public class ReminderServiceImpl implements ReminderService {
    @Autowired
    private ReminderMapper reminderMapper;

    @Override
    public Result list(int currentPage) {
        QueryWrapper<Reminder> queryWrapper = new QueryWrapper<>();

        Map<String, Object> map = ThreadLocalUtil.get();
        Integer userid = (Integer) map.get("id");

        queryWrapper.eq("user_id", userid);
        Page<Reminder> page = new Page<>(currentPage, 10);
        Page<Reminder> resultPage =  reminderMapper.selectPage(page, queryWrapper);

        return new Result(Code.GET_OK, resultPage, "查询成功");
    }

    @Override
    public Result add(ReminderDTO reminderDTO) {
        Reminder reminder = new Reminder();
        BeanUtils.copyProperties(reminderDTO, reminder);

        Map<String, Object> map = ThreadLocalUtil.get();
        Integer userid = (Integer) map.get("id");
        reminder.setUserId(userid);

        reminder.setStatus(0);

        reminderMapper.insert(reminder);
        return new Result(Code.SAVE_OK, null, "插入成功");
    }
}
