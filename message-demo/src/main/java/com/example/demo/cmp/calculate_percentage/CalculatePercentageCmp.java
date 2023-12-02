package com.example.demo.cmp.calculate_percentage;

import com.yomahub.liteflow.annotation.LiteflowComponent;
import com.yomahub.liteflow.core.NodeComponent;

import java.util.List;

/**
 * @ClassName CalculatePercentageCmp
 * @Description
 * @Author DaHuangGo
 * @Date 2023/12/1 16:37
 * @Version 0.0.1
 **/
@LiteflowComponent(id = "calculatePercentage")
public class CalculatePercentageCmp extends NodeComponent {

    @Override
    public void process() throws Exception {
        CaculateContext caculateContext = this.getContextBean(CaculateContext.class);
        try {
            List<Float> allHigher = caculateContext.getAllHigher();
            List<Float> allLower = caculateContext.getAllLower();
            calculateRatio(allHigher,allLower);
            caculateContext.success();
        }catch (Exception e){
            caculateContext.reset();
        }
    }


    private float calculateRatio(List<Float> allHigher, List<Float> allLower) {
        float sumHigher = allHigher.stream().reduce(0f, Float::sum);
        float sumLower = allLower.stream().reduce(0f, Float::sum);

        if (sumLower == 0) {
            // 避免除以零错误
            return 0;
        }

        return sumLower / sumHigher ;
    }
}
