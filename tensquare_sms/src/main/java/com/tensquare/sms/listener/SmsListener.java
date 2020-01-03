package com.tensquare.sms.listener;

import com.aliyuncs.exceptions.ClientException;
import com.tensquare.sms.utils.SmsUtil;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.sound.midi.Soundbank;
import java.sql.SQLOutput;
import java.util.Map;

/**
 * SmsListener
 *
 * @author Paulson
 * @date 2020/1/3 1:18
 */
@Component
@RabbitListener(queues = "sms")
public class SmsListener {

    @Autowired
    private SmsUtil smsUtil;

    @Value("${aliyun.sms.template_code}")
    private String template_code;

    @Value("${aliyun.sms.sign_name}")
    private String sign_name;


    @RabbitHandler
    public void executeSms(Map<String, String> map){
        /*
        template_code: SMS_181866518
        sign_name: ybs_check
         */
        String mobile = map.get("mobile");
        String checkcode = map.get("checkcode");
        System.out.println("手机号: " + mobile);
        System.out.println("验证码: " + checkcode);
        try {
            smsUtil.sendSms(mobile, template_code, sign_name, "{\"checkcode\":\""+ checkcode +"\"}");
        } catch (ClientException e) {
            e.printStackTrace();
        }
    }
}
