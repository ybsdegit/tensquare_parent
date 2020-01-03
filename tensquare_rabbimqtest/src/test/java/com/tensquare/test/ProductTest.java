package com.tensquare.test;

import com.tensquare.rabbit.RabbitApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * ProductTest
 *
 * @author Paulson
 * @date 2020/1/2 22:58
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = RabbitApplication.class)
public class ProductTest {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    public void sendMsg1(){
        rabbitTemplate.convertAndSend("ybs", "this is a rabbit message! 您收到了吗?直接模式");
    }

    /**
     * 分裂模式
     */
    @Test
    public void sendMsg2(){
        rabbitTemplate.convertAndSend("yuanbao", "","分裂模式发送消息测试");
    }

    /**
     * 主题模式
     */
    @Test
    public void sendMsg3(){
        rabbitTemplate.convertAndSend("topictest", "good.log","主题模式发送消息测试");
    }
}
