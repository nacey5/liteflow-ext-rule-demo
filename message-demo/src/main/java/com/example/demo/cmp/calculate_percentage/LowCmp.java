package com.example.demo.cmp.calculate_percentage;

import com.yomahub.liteflow.annotation.LiteflowComponent;
import com.yomahub.liteflow.annotation.LiteflowRetry;
import com.yomahub.liteflow.core.NodeComponent;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @ClassName LowCMp
 * @Description
 * @Author DaHuangGo
 * @Date 2023/12/1 16:25
 * @Version 0.0.1
 **/
@LiteflowComponent(id = "lower")
//@LiteflowRetry(5)
public class LowCmp extends NodeComponent {
    @Override
    public void process() throws Exception {

        CaculateContext caculateContext = this.getContextBean(CaculateContext.class);
        if (caculateContext.isSuccess()){
            caculateContext.reset();
            try {
                List<Float> allLower = caculateContext.getAllLower();
                List<Float> increasedValues = allLower.stream().map(this::decrease).collect(Collectors.toList());
                caculateContext.setAllLower(increasedValues);
                caculateContext.success();
            }catch (Exception e){
                caculateContext.reset();
            }
        }

    }


    private Float decrease(Float data) {
        return data += 100;
    }
}

