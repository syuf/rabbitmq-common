package com.zlpay.rabbitmq.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Data;

@Data
@ConfigurationProperties(prefix = "spring.rabbitmq")
public class RabbitmqProperties {
	/**
	 * 队列地址
	 */
	private String addresses;
	/**
	 * 用户名
	 */
	private String username;
	/**
	 * 密码
	 */
	private String password;
	/**
	 * 虚拟机
	 */
	private String virtualHost;
	/**
	 * 消息确认
	 */
	private boolean publisherConfirms;
	/**
	 * 消息回调
	 */
	private boolean publisherReturns;
	/**
	 * mandatory标志位,只有为true,消息回调才会生效
	 */
	private boolean templateMandatory;
	/**
	 * 消费消息确认模式
	 */
	private String listenerDirectAcknowledgeMode;
}
