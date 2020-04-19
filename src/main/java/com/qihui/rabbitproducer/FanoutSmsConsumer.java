package com.qihui.rabbitproducer;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import static com.qihui.rabbitproducer.FanoutConfig.FANOUT_SMS_QUEUE;

/**
 * @author chenqihui
 * @date 2020/4/19
 */
@Component
@RabbitListener(queues = FANOUT_SMS_QUEUE)
public class FanoutSmsConsumer {
    @RabbitHandler
    public void process(User user) {
        System.out.println("send a message to " + user.getName() + ", phone number is " + user.getPhone());
    }
}
