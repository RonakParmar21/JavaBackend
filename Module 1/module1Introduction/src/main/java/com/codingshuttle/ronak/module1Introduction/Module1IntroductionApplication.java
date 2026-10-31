package com.codingshuttle.ronak.module1Introduction;

import com.codingshuttle.ronak.module1Introduction.impl.EmailNotificationService;
import com.codingshuttle.ronak.module1Introduction.impl.SmsNotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class Module1IntroductionApplication implements CommandLineRunner {

//	@Autowired // remove in constructor DI
//	final NotificationService notificationServiceObj; // dependency injection and this is field DI
//
//	public Module1IntroductionApplication(NotificationService notificationServiceObj) {
//		this.notificationServiceObj = notificationServiceObj; // constructor DI and preferred.
//	}

	@Autowired
	Map<String, NotificationService> notificationServiceMap = new HashMap<>();

	public static void main(String[] args) {
		SpringApplication.run(Module1IntroductionApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		NotificationService notificationServiceObj = new EmailNotificationService(); // this is not spring boot way

//		notificationServiceObj.send("Hello");


//		create all bean
		for (var notificationService : notificationServiceMap.entrySet()) {
			System.out.println(notificationService.getKey());
			notificationService.getValue().send("Hello");
		}
	} 
}
