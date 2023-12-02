package com.example.demo.contoller;

import com.example.demo.bo.Employee;
import com.example.demo.cmp.calculate_percentage.CaculateContext;
import com.example.demo.service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @ClassName CaculateController
 * @Description
 * @Author DaHuangGo
 * @Date 2023/12/1 16:52
 * @Version 0.0.1
 **/
@RestController
public class CaculateController {

    @Resource
    private EmployeeService employeeService;

    @GetMapping("/getSql2")
    public void getSql2(){
        CaculateContext caculateContext = new CaculateContext();
        try {
//            Map<String, List<Employee>> employeesByBalance = employeeService.getEmployeesByBalance(5000f);
            Map<String, List<Employee>> employeesByBalance =employeeService.getEmployeesByBalanceWithPagination(5000f,1,500);

            List<Employee> le = employeesByBalance.get("le");
            List<Employee> gr = employeesByBalance.get("gr");
            caculateContext.setAllLower(le.stream()
                    .map(Employee::getBalance)
                    .collect(Collectors.toList()));
            caculateContext.setAllLower(gr.stream()
                    .map(Employee::getBalance)
                    .collect(Collectors.toList()));
            caculateContext.success();
            System.out.println(employeesByBalance.size());
        }catch (Exception e){
            caculateContext.reset();
        }
    }

    @GetMapping("/count")
    public Integer getCount(){
        return employeeService.getCount();
    }

}
