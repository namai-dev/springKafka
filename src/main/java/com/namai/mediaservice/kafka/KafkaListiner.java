package com.namai.mediaservice.kafka;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.namai.mediaservice.EmailService.EmailSenderSevice;

import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class KafkaListiner {
    
    private final EmailSenderSevice emailSenderSevice;


    @KafkaListener(topics = "email", groupId = "group_1")
    public void liten(String emailString) throws MessagingException, IOException{
        emailSenderSevice.sendMessage(emailString, "Welcome on boar", "Comrde coin");
        System.out.println(emailString);
    }

      @KafkaListener(topics = "account", groupId = "group_2")
    public void litening(String account_details) throws MessagingException, IOException{
        System.out.println(account_details);
        try {
            ObjectMapper mapper = new ObjectMapper();
            JsonNode jsonNode = mapper.readTree(account_details);
            String email = jsonNode.get("email").asText();
            Long account_number = jsonNode.get("account_number").asLong();
            Double balance = jsonNode.get("balance").asDouble();
            emailSenderSevice.sendAccontDetails(email, "Account Details", balance, account_number);

            System.out.println(account_number);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            // TODO: handle exception
        }
    }
    
}
