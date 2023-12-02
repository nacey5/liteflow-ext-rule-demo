package com.example.demo.node_init;

/**
 * @ClassName CommonNode
 * @Description
 * @Author DaHuangGo
 * @Date 2023/11/24 11:15
 * @Version 0.0.1
 **/
public enum CommonNode {

    BATCH_SENDER("batchSender"),
    BIZ1("biz1"),
    CHANNEL1("channel1"),
    CHANNEL1_QUERY("channel1Query"),
    CHANNEL2("channel2"),
    CHANNEL2_QUERY("channel2Query"),
    CHANNEL3("channel3"),
    CHANNEL3_QUERY("channel3Query"),
    CHANNEL4("channel4"),
    CHANNEL4_QUERY("channel4Query"),
    CHANNEL5("channel5"),
    CHANNEL5_QUERY("channel5Query"),
    CHANNEL6("channel6"),
    CHANNEL6_QUERY("channel6Query"),
    CHANNEL_SELECTOR("channelSelector"),
    PACKAGE_DATA("packageData")
    ;

    private final String value;

    CommonNode(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
