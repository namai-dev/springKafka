// package com.namai.mediaservice.EmailService;

// import java.util.Properties;

// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.mail.javamail.JavaMailSender;
// import org.springframework.mail.javamail.JavaMailSenderImpl;

// @Configuration
// public class EmailConfig {

//     @Bean
//     public JavaMailSender javaMailSender(){
//         JavaMailSenderImpl impl = new JavaMailSenderImpl();
//         impl.setHost("smtp.gmail.com");
//         impl.setPort(587);
//         impl.setUsername("namaihamony4@gmail.com");
//         impl.setPassword("zxot psck elsm tzhm");
        

//         Properties props = impl.getJavaMailProperties();
//         props.put("mail.transport.protocol", "smtp");
//         props.put("mail.smtp.auth", "true");
//         props.put("mail.smtp.starttls.enable", "true");
//         props.put("mail.debug", "true");
//         return impl;

//     }
    
// }
