package com.wu.demo.sendemail.controller;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * @author Junchi.Song
 */
@Controller
public class SendMailController {

  @Autowired
  private JavaMailSender javaMailSender;
  @RequestMapping("/main")
  public String hello() throws Exception {
   
    return "index";
  }
  @RequestMapping("/send")
  public String say(HttpServletRequest request, HttpSession session) throws Exception {
    String sendEmail = request.getParameter("sendEmail");
    String receiveEmail = request.getParameter("receiveEmail");
    contextLoads(sendEmail, receiveEmail);
    return "done";
  }

  private void contextLoads(String sendEmail, String receiveEmail) throws MessagingException {
    MimeMessage mimeMessage = javaMailSender.createMimeMessage();
    MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
    helper.setFrom(sendEmail);
    helper.setTo(receiveEmail);
    helper.setSubject("Test");
    helper.setText("Junchi Song");
    javaMailSender.send(mimeMessage);
  }

  @RequestMapping("/welcome")
  public String we() {
    return "welcome.html";
  }
}
