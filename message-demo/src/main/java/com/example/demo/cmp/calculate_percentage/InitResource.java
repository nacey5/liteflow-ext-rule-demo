package com.example.demo.cmp.calculate_percentage;

import com.example.demo.bo.Employee;
import com.example.demo.service.EmployeeService;
import com.yomahub.liteflow.annotation.LiteflowComponent;
import com.yomahub.liteflow.core.NodeComponent;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @ClassName InitResource
 * @Description
 * @Author DaHuangGo
 * @Date 2023/12/1 16:58
 * @Version 0.0.1
 **/
@LiteflowComponent("initResource")
public class InitResource extends NodeComponent {

    @Resource
    private EmployeeService employeeService;

    @Override
    public void process() throws Exception {
        CaculateContext caculateContext = this.getContextBean(CaculateContext.class);
        try {
            Map<String, List<Employee>> employeesByBalance = employeeService.getEmployeesByBalance(5000f);
            List<Employee> le = employeesByBalance.get("le");
            List<Employee> gr = employeesByBalance.get("gr");
            caculateContext.setAllLower(le.stream()
                    .map(Employee::getBalance)
                    .collect(Collectors.toList()));
            caculateContext.setAllLower(gr.stream()
                    .map(Employee::getBalance)
                    .collect(Collectors.toList()));
            caculateContext.success();
        }catch (Exception e){
            caculateContext.reset();
        }

    }
}
