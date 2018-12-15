package com.test.seminar.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
<<<<<<< HEAD
=======
import javax.mail.internet.MimeMessage;
>>>>>>> b5d964932e63aa2fc0f79f68e4de55f7076ff3fa
import org.springframework.stereotype.Component;

@Component
public class EmailService{

    public JavaMailSender emailSender;

    public void sendSimpleMessage(String to, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        emailSender.send(message);
    }
<<<<<<< HEAD
}
=======
}
>>>>>>> b5d964932e63aa2fc0f79f68e4de55f7076ff3fa
