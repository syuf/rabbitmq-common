package com.zlpay.rabbitmq.configuration;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.zlpay.rabbitmq.enums.ExchangeEnum;
import com.zlpay.rabbitmq.enums.QueueEnum;

@Configuration
public class UserQueueConfiguration {
	/**
	 * @Description: 实例化交换机,持久化,不自动删除
	 * @author: syuf
	 * @date: 2018年7月3日 上午11:28:47
	 */
	@Bean
	public DirectExchange userRegisterDirectExchange() {
		return new DirectExchange(ExchangeEnum.USER_REGISTER.getValue(), true, false);
	}

	/**
	 * @Description: 配置用户注册队列对象实例
	 * @author: syuf
	 * @date: 2018年7月3日 上午11:30:17
	 */
	@Bean
	public Queue userRegisterQueue() {
		return new Queue(QueueEnum.USER_REGISTER.getName(), true);
	}

	/**
	 * @Description: 将用户注册队列绑定到路由交换配置上并设置指定路由键进行转发
	 * @author: syuf
	 * @date: 2018年7月3日 上午11:30:26
	 */
	@Bean
	public Binding userRegisterBinding() {
		return BindingBuilder.bind(userRegisterQueue()).to(userRegisterDirectExchange())
				.with(QueueEnum.USER_REGISTER.getRoutingKey());
	}

}
