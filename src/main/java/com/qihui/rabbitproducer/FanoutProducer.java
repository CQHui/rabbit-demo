package com.qihui.rabbitproducer;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author chenqihui
 * @date 2020/4/19
 */
@Component
public class FanoutProducer {
    private final AmqpTemplate amqpTemplate;

    public FanoutProducer(AmqpTemplate amqpTemplate) {
        this.amqpTemplate = amqpTemplate;
    }

    public void send(String queueName, User user) {
        String msg = "my_fanout_msg:" + new Date();
        System.out.println(msg + ":" + msg);
        amqpTemplate.convertAndSend(queueName, user);
    }
}
