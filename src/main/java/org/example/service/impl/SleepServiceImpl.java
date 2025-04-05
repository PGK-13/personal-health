package org.example.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.example.mapper.SleepDao;
import org.example.pojo.dto.Code;
import org.example.pojo.dto.SleepDTO;
import org.example.pojo.result.Result;
import org.example.pojo.entity.Sleep;
import org.example.service.SleepService;
import org.example.utils.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Map;

@Service
public class SleepServiceImpl implements SleepService {
    // private static final Integer PAGESIZE = 10;

    @Autowired
    private SleepDao sleepDao;

    @Override
    public Result add(Sleep sleep) {
        Map<String, Object> map = ThreadLocalUtil.get();
        Integer userid = (Integer) map.get("id");
        sleep.setUserId(userid);
        sleep.setRecordedAt(LocalDateTime.now());
        LocalDateTime start = sleep.getStartTime();
        LocalDateTime end = sleep.getEndTime();
        int hoursDiff = (int) ChronoUnit.HOURS.between(start, end); // 计算分钟差
        sleep.setDuration(hoursDiff);

        sleepDao.insert(sleep);

        return new Result(Code.SAVE_OK, sleep, "新增睡眠数据成功");
    }

    @Override
    public Result delete(Integer id) {
        try {
            sleepDao.deleteById(id);
            return new Result(Code.DELETE_OK, true, "删除睡眠数据成功");
        } catch (Exception e) {
            return new Result(Code.DELETE_ERR, false, "删除失败");
        }
    }

    @Override
    public Result list(SleepDTO sleepDTO) {
        Map<String, Object> map = ThreadLocalUtil.get();
        Integer userid = (Integer) map.get("id");

        QueryWrapper<Sleep> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", userid).select("recorded_at", "duration", "deep_sleep", "quality");
        Page<Sleep> page = new Page<>(sleepDTO.getPage(), sleepDTO.getPageSize());
        Page<Sleep> resultPage =  sleepDao.selectPage(page, queryWrapper);

        return new Result(Code.GET_OK, resultPage, "查看成功");
    }
}
