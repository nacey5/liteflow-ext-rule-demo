package com.example.demo.contoller;

import com.example.demo.bo.Employee;
import com.example.demo.bo.User;
import com.example.demo.cmp.calculate_percentage.CaculateContext;
import com.example.demo.service.EmployeeService;
import com.example.demo.service.UserService;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @ClassName HelloController
 * @Description
 * @Author DaHuangGo
 * @Date 2023/11/24 16:03
 * @Version 0.0.1
 **/
@RestController
public class HelloController {


    @Resource
    private UserService userService;

    @GetMapping("/getSql")
    public void getSql(){
        User user = userService.getUserById(1L);
        if (user!=null) {
            System.out.println("successful");
        }
    }



}
