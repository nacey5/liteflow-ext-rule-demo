package com.example.demo.service;

import com.example.demo.bo.User;
import com.example.demo.mapper.UserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName UserService
 * @Description
 * @Author DaHuangGo
 * @Date 2023/11/24 15:50
 * @Version 0.0.1
 **/

@Service
public class UserService {

    @Resource
    private UserMapper userMapper;

    // 根据ID查询用户
    public User getUserById(Long id) {
        return userMapper.selectById(id);
    }

    // 查询所有用户
    public List<User> getAllUsers() {
        return userMapper.selectList(null);
    }

    // 添加用户
    public void addUser(User user) {
        userMapper.insert(user);
    }

    // 更新用户信息
    public void updateUser(User user) {
        userMapper.updateById(user);
    }

    // 删除用户
    public void deleteUser(Long id) {
        userMapper.deleteById(id);
    }
}
