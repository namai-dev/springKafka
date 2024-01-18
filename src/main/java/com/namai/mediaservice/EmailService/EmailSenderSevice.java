package com.namai.mediaservice.EmailService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmailSenderSevice {
    
    private final JavaMailSender javaMailSender;
    private final TemplateEngine templateEngine;

    

    public void sendMessage(String to, String subject, String body) throws MessagingException, IOException{
        MimeMessage mailMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper message = new MimeMessageHelper(mailMessage);
        message.setTo(to);
        message.setSubject(subject);
        String html_tempalate = readHtmlFile("sign_up.html");

        message.setText(html_tempalate, true);


        javaMailSender.send(mailMessage);
        
    }


     public void sendAccontDetails(String to, String subject, Double balance, Long account_number) throws MessagingException, IOException{
        MimeMessage mailMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper message = new MimeMessageHelper(mailMessage);
        
        
        Context context = new Context();
        context.setVariable("username", to);
        context.setVariable("balance", balance);
        context.setVariable("account_number", account_number);

        String html_tempalate = templateEngine.process("user_details", context);
        message.setTo(to);
        message.setSubject(subject);
        message.setText(html_tempalate, true);
        javaMailSender.send(mailMessage);
        
    }

      private String readHtmlFile(String templateFileName) throws IOException {
        // Read the HTML content from the file
        Path path = Paths.get(new ClassPathResource(templateFileName).getURI());
        return new String(Files.readAllBytes(path));
      }
    
}
