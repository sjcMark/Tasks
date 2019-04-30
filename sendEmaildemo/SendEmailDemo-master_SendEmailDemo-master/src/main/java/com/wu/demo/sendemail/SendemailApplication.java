package com.wu.demo.sendemail;

import javax.mail.internet.MimeMessage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

@SpringBootApplication
public class SendemailApplication {

    public static void main(String[] args) {

        SpringApplication.run(SendemailApplication.class, args);
      
    }
}
