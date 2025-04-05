package org.example.service.impl;

import org.example.mapper.VitalSignDao;
import org.example.pojo.dto.Code;
import org.example.pojo.result.Result;
import org.example.pojo.entity.VitalSign;
import org.example.service.VitalSignService;
import org.example.utils.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Map;

@Service
public class VitalSignServiceImpl implements VitalSignService {

    @Autowired
    private VitalSignDao vitalSignDao;

    @Override
    public Result update(VitalSign vitalSign) {
        vitalSign.setRecordedAt(LocalDateTime.now());
        Map<String, Object> map = ThreadLocalUtil.get();
        vitalSign.setUserId((Integer) map.get("id"));
        int row = vitalSignDao.updateById(vitalSign);
        if (row > 0) {
            return new Result(Code.UPDATE_OK, "更新成功");
        } else {
            return new Result(Code.UPDATE_ERR, "更新失败");
        }
    }

    @Override
    public Result list() {
        Map<String, Object> map = ThreadLocalUtil.get();
        Integer userid = (Integer) map.get("id");
        VitalSign vitalSign = vitalSignDao.selectById(userid);
        if (vitalSign != null) {
            return new Result(Code.GET_OK, vitalSign, "查询成功");
        } else {
            return new Result(Code.GET_ERR, null, "查询失败");
        }
    }

}
