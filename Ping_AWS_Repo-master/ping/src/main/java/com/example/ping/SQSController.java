package com.example.ping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.aws.autoconfigure.context.ContextStackAutoConfiguration;
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;
import org.springframework.messaging.support.MessageBuilder;


@SpringBootApplication(exclude = {ContextStackAutoConfiguration.class})
public class SQSController implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(SQSController.class, args);
    }

    @Autowired
    public QueueMessagingTemplate queueMessagingTemplate;

    @Value("${cloud.aws.end-point.uri}")
    private String sqsEndPoint;

    public void sendMessage() throws InterruptedException {
        while (true) {
            queueMessagingTemplate.send(sqsEndPoint, MessageBuilder.withPayload("Hello from Ping...!").build());
            Thread.sleep(5000);
        }
    }

    @Override
    public void run(String... args) throws Exception {
        sendMessage();
    }
}
