package com.zlpay.rabbitmq.service;

import com.zlpay.rabbitmq.enums.ExchangeEnum;
import com.zlpay.rabbitmq.enums.QueueEnum;

public interface ProducerService {
	
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
	void send(ExchangeEnum exchange, QueueEnum queue,String msg,String msgId);
}
