package org.example.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.example.mapper.UserDao;
import org.example.mapper.VitalSignDao;
import org.example.pojo.dto.Code;
import org.example.pojo.dto.LoginDTO;
import org.example.pojo.result.Result;
import org.example.pojo.entity.User;
import org.example.pojo.entity.VitalSign;
import org.example.service.UserService;
import org.example.utils.JwtUtil;
import org.example.utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private VitalSignDao vitalSignDao;

    @Override
    public Result register(User user) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", user.getUsername());
        User existUser = userDao.selectOne(queryWrapper);
        if(existUser != null) {
            return new Result(Code.SAVE_ERR, null,"注册失败，用户名已存在");
        }

        user.setPassword(MD5Util.encrypt(user.getPassword()));
        user.setCreatedAt(LocalDateTime.now());
        userDao.insert(user);

        VitalSign vitalSign = new VitalSign();
        vitalSign.setUserId(user.getUserId());
        vitalSign.setRecordedAt(LocalDateTime.now());
        vitalSignDao.insert(vitalSign);

        return new Result(Code.SAVE_OK, user, "注册成功");
    }

    @Override
    public User findByUserName(String username) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", username);
        User user = userDao.selectOne(queryWrapper);
        return user;
    }

    @Override
    public Result login(LoginDTO loginDTO) {
        User existUser = findByUserName(loginDTO.getUsername());

        if(existUser == null) {
            return new Result(Code.GET_ERR, null, "登录失败，找不到用户");
        }

        if (MD5Util.encrypt(loginDTO.getPassword()).equals(existUser.getPassword())) {
            Map<String, Object> claims = new HashMap<>();
            claims.put("id", existUser.getUserId());
            claims.put("username", existUser.getUsername());
            String token = JwtUtil.genToken(claims);
            return new Result(Code.GET_OK, token, "登录成功");
        }

        return new Result(Code.GET_ERR, null, "登录失败，密码错误");
    }
}
