package com.zlpay.rabbitmq.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;

import com.zlpay.rabbitmq.enums.ExchangeEnum;
import com.zlpay.rabbitmq.enums.QueueEnum;

public abstract class AbstractProducer implements ProducerService{

	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	@Override
	public void send(ExchangeEnum exchange, QueueEnum queue,String msg,String msgId) {
        CorrelationData correlationData = new CorrelationData(msgId);
        this.rabbitTemplate.convertAndSend(exchange.getValue(), queue.getRoutingKey(), msg, correlationData);
    }
}
