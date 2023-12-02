package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.bo.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @ClassName UserMapper
 * @Description
 * @Author DaHuangGo
 * @Date 2023/11/24 15:42
 * @Version 0.0.1
 **/
@Mapper
public interface UserMapper extends BaseMapper<User> {
}
