package com.qihui.rabbitproducer;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import static com.qihui.rabbitproducer.FanoutConfig.FANOUT_EMAIL_QUEUE;

/**
 * @author chenqihui
 * @date 2020/4/19
 */
@Component
@RabbitListener(queues = "fanout_email_queue")
public class FanoutEmailConsumer {
    @RabbitHandler
    public void process(User user) {
        System.out.println("send a email to " + user.getName() + ", email address is " + user.getEmail());
    }
}
