package com.namai.mediaservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka
public class MediaserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MediaserviceApplication.class, args);
	}

}
