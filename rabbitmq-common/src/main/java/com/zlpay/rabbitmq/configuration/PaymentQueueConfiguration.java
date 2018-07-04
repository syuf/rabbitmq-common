package com.zlpay.rabbitmq.configuration;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.zlpay.rabbitmq.enums.ExchangeEnum;
import com.zlpay.rabbitmq.enums.QueueEnum;

@Configuration
public class PaymentQueueConfiguration {
	
	/**
	 * @Description: 实例化Direct交换机,持久化,不自动删除
	 * @author: syuf
	 * @date: 2018年7月3日 上午11:28:47
	 */
	@Bean
	public DirectExchange payDirectExchange() {
		return new DirectExchange(ExchangeEnum.PAY_DIRECT_EXCHANGE.getValue(), true, false);
	}
	
	/**
	 * @Description: 实例化Topic交换机,持久化,不自动删除
	 * @author: syuf
	 * @date: 2018年7月3日 上午11:28:47
	 */
	@Bean
	public TopicExchange payTopicExchange() {
		return new TopicExchange(ExchangeEnum.PAY_TOPIC_EXCHANGE.getValue(), true, false);
	}
	
	/**
	 * @Description: 创建支付业务短信队列
	 * @author: syuf
	 * @date: 2018年7月3日 上午11:30:17
	 */
	@Bean
	public Queue payMsmQueue() {
		return new Queue(QueueEnum.PAY_MSM_TOPIC.getName(), true);
	}

	/**
	 * @Description: 创建支付业务邮件队列
	 * @author: syuf
	 * @date: 2018年7月3日 上午11:30:17
	 */
	@Bean
	public Queue payEmailQueue() {
		return new Queue(QueueEnum.PAY_EMAIL_TOPIC.getName(), true);
	}

	/**
	 * @Description: topic交换机与短信队列绑定
	 * @author: syuf
	 * @date: 2018年7月3日 上午11:30:26
	 */
	@Bean
	public Binding payMsmBinding() {
		return BindingBuilder.bind(payMsmQueue()).to(payTopicExchange()).with(QueueEnum.PAY_MSM_TOPIC.getRoutingKey());
	}
	
	/**
	 * @Description: topic交换机与邮件队列绑定
	 * @author: syuf
	 * @date: 2018年7月3日 上午11:30:26
	 */
	@Bean
	public Binding payEmailBinding() {
		return BindingBuilder.bind(payEmailQueue()).to(payTopicExchange()).with(QueueEnum.PAY_EMAIL_TOPIC.getRoutingKey());
	}

}
