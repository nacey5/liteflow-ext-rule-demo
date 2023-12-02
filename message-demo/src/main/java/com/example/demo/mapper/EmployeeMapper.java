package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.bo.Employee;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @ClassName EmployeeMapper
 * @Description
 * @Author DaHuangGo
 * @Date 2023/12/1 17:02
 * @Version 0.0.1
 **/
@Mapper
public interface EmployeeMapper extends BaseMapper<Employee> {

    @Select("SELECT COUNT(*) FROM employee")
    int countTotalEmployees();
}
