package com.zlpay.rabbitmq.enums;

import lombok.Getter;
/**
 * @Description: 队列枚举
 * @author: syuf
 * @date: 2018年7月4日 下午2:11:38
 */
@Getter
public enum QueueEnum {
    PAY_MSM_TOPIC("pay.msm","pay.#"),
    PAY_EMAIL_TOPIC("pay.email","pay.#"),
    SASS_DIRECT("sass","sass"),
    ;
    /**
     * 队列名称
     */
    private String name;
    /**
     * 绑定路由键
     */
    private String routingKey;

    QueueEnum(String name, String routingKey) {
        this.name = name;
        this.routingKey = routingKey;
    }

}
