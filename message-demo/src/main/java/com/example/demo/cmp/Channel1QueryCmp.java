package com.example.demo.cmp;

import com.example.demo.context.BatchMessageResultContext;
import com.example.demo.node_init.CommonNode;
import com.example.demo.vo.QueryVO;
import com.yomahub.liteflow.annotation.LiteflowComponent;
import com.yomahub.liteflow.core.NodeComponent;

import java.util.Random;

@LiteflowComponent(id = "channel1Query", name = "获取渠道1剩余量")
public class Channel1QueryCmp extends NodeComponent {
    @Override
    public void process() throws Exception {
        //模拟查询业务耗时
        int time = new Random().nextInt(1000);
        Thread.sleep(time);

        //mock下渠道1有2w条剩余量
        BatchMessageResultContext context = this.getFirstContextBean();
        context.addQueryVO(new QueryVO(CommonNode.CHANNEL1.getValue(), 20000));
    }
}
