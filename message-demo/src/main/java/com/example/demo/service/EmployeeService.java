package com.example.demo.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.bo.Employee;
import com.example.demo.mapper.EmployeeMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName EmployeeService
 * @Description
 * @Author DaHuangGo
 * @Date 2023/12/1 17:02
 * @Version 0.0.1
 **/

@Service
public class EmployeeService {

    @Resource
    private EmployeeMapper employeeMapper;

    public List<Employee> getAllEmployees() {
        return employeeMapper.selectList(null);
    }

    public Employee getEmployeeById(Long id) {
        return employeeMapper.selectById(id);
    }

    public void saveEmployee(Employee employee) {
        employeeMapper.insert(employee);
    }

    public void updateEmployee(Employee employee) {
        employeeMapper.updateById(employee);
    }

    public void deleteEmployeeById(Long id) {
        employeeMapper.deleteById(id);
    }

    // 可以根据需要添加其他操作数据库表的方法

    public Map<String,List<Employee>> getEmployeesByBalance(Float balance) {
        Map<String,List<Employee>> map=new HashMap<>();
        // 使用条件构造器进行条件查询
        List<Employee> lessThan = employeeMapper.selectList(Wrappers.<Employee>lambdaQuery()
                .le(Employee::getBalance, balance));

        List<Employee> greaterThan = employeeMapper.selectList(Wrappers.<Employee>lambdaQuery()
                .gt(Employee::getBalance, balance));

        map.put("le",lessThan);
        map.put("gr",greaterThan);

        // 返回满足条件的列表
        return map;
    }

    public Map<String,List<Employee>> getEmployeesByBalanceWithPagination(Float balance, int pageNum, int pageSize) {

        Map<String,List<Employee>> map=new HashMap<>();
        Page<Employee> page = new Page<>(pageNum, pageSize);
        LambdaQueryWrapper<Employee> queryWrapper = Wrappers.<Employee>lambdaQuery()
                .le(Employee::getBalance, balance);
        employeeMapper.selectPage(page, queryWrapper);

        List<Employee> lessThan=page.getRecords();
        queryWrapper = Wrappers.<Employee>lambdaQuery()
                .gt(Employee::getBalance, balance);
        employeeMapper.selectPage(page, queryWrapper);
        List<Employee> greaterThan =page.getRecords();;

        map.put("le",lessThan);
        map.put("gr",greaterThan);

        // 返回满足条件的列表
        return map;
    }

    public Integer getCount(){
        return employeeMapper.countTotalEmployees();
    }

}
