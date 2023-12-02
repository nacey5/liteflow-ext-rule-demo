package com.example.demo.bo;

import com.baomidou.mybatisplus.annotation.TableName;

/**
 * @ClassName User
 * @Description
 * @Author DaHuangGo
 * @Date 2023/11/24 15:40
 * @Version 0.0.1
 **/
@TableName("user") // 对应数据库中的表名
public class User {
    private Long id;
    private Integer age;
    private String  gender;
    private Long total_price;
}
