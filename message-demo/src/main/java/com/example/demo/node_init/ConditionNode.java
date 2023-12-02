package com.example.demo.node_init;

/**
 * @ClassName IFNode
 * @Description
 * @Author DaHuangGo
 * @Date 2023/11/24 11:20
 * @Version 0.0.1
 **/
public enum ConditionNode {

    IF_1("if_1"),
    IF_2("if_2"),
    IF_3("if_3")
    ;
    private final String value;

    ConditionNode(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
