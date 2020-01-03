package com.tensquare.rabbit.customer;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Customer1
 *
 * @author Paulson
 * @date 2020/1/2 23:04
 */

@Component
@RabbitListener(queues = "paulson")
public class Customer2 {

    @RabbitHandler
    public void getMsg(String msg){
        System.out.println("paulson收到消费消息: "+msg);
    }

}
