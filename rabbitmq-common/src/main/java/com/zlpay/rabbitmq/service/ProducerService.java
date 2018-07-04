package com.zlpay.rabbitmq.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;

import com.zlpay.rabbitmq.enums.ExchangeEnum;

public interface ProducerService extends RabbitTemplate.ConfirmCallback,RabbitTemplate.ReturnCallback{
	
	/**
	* @Description: 发送字符串消息  
	* @param exchange
	* @param queue
	* @param msg
	* @param msgId 消息ID
	* @return void
	* @throws  
	* @author: syuf
	* @date: 2018年7月3日 下午2:56:35
	 */
	void send(ExchangeEnum exchange,String routingKey,String msg,String msgId);
}
