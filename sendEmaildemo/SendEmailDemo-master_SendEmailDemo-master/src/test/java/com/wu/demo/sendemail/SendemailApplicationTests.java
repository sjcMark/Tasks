package com.wu.demo.sendemail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Properties;

import javax.mail.internet.MimeMessage;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SendemailApplicationTests {

    @Autowired
    private JavaMailSender javaMailSender;

    @Test
    public String contextLoads(String SendEmail, String receiveEmail) throws Exception{

    	MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        // 发送方邮箱
        helper.setFrom(SendEmail);
        // 接收方邮箱
        helper.setTo(receiveEmail);
        // 主题
        helper.setSubject("Test");
        // 内容
        helper.setText("Junchi Song");
        javaMailSender.send(mimeMessage);
        return "Send successfully";

    }

}
