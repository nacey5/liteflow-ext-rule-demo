package com.example.demo.cmp.calculate_percentage;

import com.yomahub.liteflow.annotation.LiteflowComponent;
import com.yomahub.liteflow.core.NodeSwitchComponent;

/**
 * @ClassName selectSwitchCmp
 * @Description
 * @Author DaHuangGo
 * @Date 2023/12/1 16:04
 * @Version 0.0.1
 **/
@LiteflowComponent(id = "select", name = "balance判断")
public class SelectSwitchCmp extends NodeSwitchComponent {

    @Override
    public String processSwitch() throws Exception {
        CaculateContext caculateContext = this.getContextBean(CaculateContext.class);
        return null;
    }
}
