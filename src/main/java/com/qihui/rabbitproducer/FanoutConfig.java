package com.qihui.rabbitproducer;


import com.rabbitmq.client.ConnectionFactory;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.support.converter.ClassMapper;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @author chenqihui
 * @date 2020/4/19
 */
@Component
public class FanoutConfig {
    public static final String FANOUT_EMAIL_QUEUE = "fanout_email_queue";
    public static final String FANOUT_SMS_QUEUE = "fanout_sms_queue";
    public static final String FANOUT_EXCHANGE = "fanoutExchange";

    @Bean
    public Queue fanOutEmailQueue() {
        return new Queue(FANOUT_EMAIL_QUEUE);
    }

    @Bean
    public Queue fanOutSmsQueue() {
        return new Queue(FANOUT_SMS_QUEUE);
    }

    @Bean
    public FanoutExchange fanoutExchange() {
        return new FanoutExchange(FANOUT_EXCHANGE);
    }

    @Bean
    public Binding bindingExchangeEmail(Queue fanOutEmailQueue, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(fanOutEmailQueue).to(fanoutExchange);
    }

    @Bean
    public Binding bindingExchangeSms(Queue fanOutSmsQueue, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(fanOutSmsQueue).to(fanoutExchange);
    }

//    @Bean
//    public Jackson2JsonMessageConverter customConverter() {
//        Jackson2JsonMessageConverter converter = new Jackson2JsonMessageConverter();
//        converter.setClassMapper(new ClassMapper() {
//            @Override
//            public Class<?> toClass(MessageProperties properties) {
//                throw new UnsupportedOperationException("this mapper is only for outbound, do not use for receive message");
//            }
//            @Override
//            public void fromClass(Class<?> clazz, MessageProperties properties) {
//                properties.setHeader("__TypeId__", "com.xxx.B");
//            }
//        });
//        return converter;
//    }
}
