package com.qihui.rabbitproducer.controller;

import com.qihui.rabbitproducer.FanoutProducer;
import com.qihui.rabbitproducer.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chenqihui
 * @date 2020/4/19
 */
@RestController
@RequestMapping("/api")
public class ProducerController {
    private final FanoutProducer fanoutProducer;

    public ProducerController(FanoutProducer fanoutProducer) {
        this.fanoutProducer = fanoutProducer;
    }

    @GetMapping("/sendFanout")
    public String sendFanout(String queueName) {
        User user = new User("Elliott", "13333333333", "13333333333@gamil.com");
        fanoutProducer.send(queueName, user);
        return "success";
    }
}
