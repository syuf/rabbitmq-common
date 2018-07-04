package com.zlpay.rabbitmq.enums;

import lombok.Getter;

/**
 * @Description: 交换机枚举
 * @author: syuf
 * @date: 2018年7月4日 下午2:01:05
 */
@Getter
public enum ExchangeEnum {
	/**
     * 支付业务
     */
    PAY_TOPIC_EXCHANGE("pay.topic"),
    PAY_DIRECT_EXCHANGE("pay.direct")
    ;
    private String value;

    ExchangeEnum(String value) {
        this.value = value;
    }
}
