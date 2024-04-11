package com.exercise.contactusform.service;

import com.exercise.contactusform.model.ContactUs;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.mail.MailProperties;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class ContactUsMailServiceImpl implements ContactUsMailServiceInterface{

    private JavaMailSender mailSender;

    @Autowired
    public ContactUsMailServiceImpl(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    @Override
    public boolean sendEmail(ContactUs contactUs) {

        try{

            String toAddress = "email@gmail.com";
            String fromAddress = contactUs.getEmail();

            String senderName = contactUs.getFullName();
            String subject = contactUs.getSubject();
            String content = contactUs.getMessage();

            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message);

            helper.setFrom(fromAddress, senderName);
            helper.setTo(toAddress);
            helper.setSubject(subject);
            helper.setText(content, true);

            mailSender.send(message);

            return true;

        }catch (MessagingException | UnsupportedEncodingException e){
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
        }

        return false;
    }


}
