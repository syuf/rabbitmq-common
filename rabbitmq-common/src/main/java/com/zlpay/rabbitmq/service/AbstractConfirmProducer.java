package com.zlpay.rabbitmq.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zlpay.rabbitmq.enums.ExchangeEnum;
import com.zlpay.rabbitmq.enums.QueueEnum;

@Component
public abstract class AbstractConfirmProducer extends AbstractProducer implements RabbitTemplate.ConfirmCallback,RabbitTemplate.ReturnCallback{

	public RabbitTemplate rabbitTemplate;
	
	@Autowired
    public AbstractConfirmProducer(RabbitTemplate rabbitTemplate) {
		this.rabbitTemplate = rabbitTemplate;
		this.rabbitTemplate.setConfirmCallback(this);
		this.rabbitTemplate.setReturnCallback(this);
		this.rabbitTemplate.setMandatory(true);
    }
	
	@Override
	public void send(ExchangeEnum exchange, QueueEnum queue, String msg, String msgId) {
		CorrelationData correlationData = new CorrelationData(msgId);
        this.rabbitTemplate.convertAndSend(exchange.getValue(), queue.getRoutingKey(), msg, correlationData);
	}
}
