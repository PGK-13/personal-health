package org.example.service;

import org.example.pojo.dto.LoginDTO;
import org.example.pojo.result.Result;
import org.example.pojo.entity.User;

public interface UserService {
    Result register(User user);
    User findByUserName(String username);
    Result login(LoginDTO loginDTO);
}
