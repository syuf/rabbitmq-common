package com.zlpay.rabbitmq.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zlpay.rabbitmq.enums.ExchangeEnum;

@Component
public abstract class AbstractProducer implements ProducerService{

	public RabbitTemplate rabbitTemplate;
	
	@Autowired
    public AbstractProducer(RabbitTemplate rabbitTemplate) {
		this.rabbitTemplate = rabbitTemplate;
		this.rabbitTemplate.setConfirmCallback(this);
		this.rabbitTemplate.setReturnCallback(this);
		this.rabbitTemplate.setMandatory(true);
    }
	
	@Override
	public void send(ExchangeEnum exchange, String routingKey,String msg,String msgId) {
        CorrelationData correlationData = new CorrelationData(msgId);
        this.rabbitTemplate.convertAndSend(exchange.getValue(), routingKey, msg, correlationData);
    }
}
