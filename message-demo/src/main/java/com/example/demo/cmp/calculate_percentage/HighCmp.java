package com.example.demo.cmp.calculate_percentage;

import com.yomahub.liteflow.annotation.LiteflowComponent;
import com.yomahub.liteflow.annotation.LiteflowRetry;
import com.yomahub.liteflow.core.NodeComponent;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @ClassName HighCmp
 * @Description
 * @Author DaHuangGo
 * @Date 2023/12/1 16:26
 * @Version 0.0.1
 **/
@LiteflowComponent(id = "higher")
//@LiteflowRetry(5)
public class HighCmp extends NodeComponent {

    @Override
    public void process() throws Exception {
        CaculateContext caculateContext = this.getContextBean(CaculateContext.class);
        if (caculateContext.isSuccess()) {
            caculateContext.reset();
            try {
                List<Float> allHigher = caculateContext.getAllHigher();
                List<Float> increasedValues= allHigher.stream().map(this::increase).collect(Collectors.toList());
                caculateContext.setAllLower(increasedValues);
                caculateContext.success();;
            }catch (Exception e){
                caculateContext.reset();
            }
        }

    }


    private Float increase(Float data){
        return data *= 1.1f;
    }
}
