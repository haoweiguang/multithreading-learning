package com.light.springamqp.broadcast;

import com.rabbitmq.client.Channel;
import lombok.SneakyThrows;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.Map;
import java.util.concurrent.ThreadPoolExecutor;

import static com.light.springamqp.broadcast.BroadcastConfig.*;

/**
 * Simple test application to send messages to rabbitMQ.
 *
 * <p>To run this particular application with mvn you use the following command:</p>
 * {@code
 * mvn spring-boot:run -Dstart-class=com.light.springamqp.broadcast.BroadcastMessageApp
 * }
 */
@SpringBootApplication
public class BroadcastMessageApp {
    private static String ROUTING_KEY_USER_IMPORTANT_WARN = "user.important.warn";
    private static String ROUTING_KEY_USER_IMPORTANT_ERROR = "user.important.error";
    @Autowired
    private ThreadPoolTaskExecutor taskExecutor;

    public static void main(String[] args) {
        SpringApplication.run(BroadcastMessageApp.class, args);
    }

    @Bean
    public ApplicationRunner runner(RabbitTemplate rabbitTemplate) {
        String message = " payload is broadcast";
        return args -> {
            for (int i = 0; i < 100000; i++) {
                rabbitTemplate.convertAndSend(BroadcastConfig.FANOUT_EXCHANGE_NAME, "", "fanout" + message + i);
                System.out.println("第" + i + "次发送成功");
            }
//            rabbitTemplate.convertAndSend(BroadcastConfig.TOPIC_EXCHANGE_NAME, ROUTING_KEY_USER_IMPORTANT_WARN, "topic important warn" + message);
//            rabbitTemplate.convertAndSend(BroadcastConfig.TOPIC_EXCHANGE_NAME, ROUTING_KEY_USER_IMPORTANT_ERROR, "topic important error" + message);
        };
    }

    @RabbitListener(queues = {FANOUT_QUEUE_1_ASYN_NAME})
    public void receiveMessageFromAsynFanout1(Message message, Channel channel) {
        taskExecutor.execute(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                System.out.println("Received fanout 1 message: " + message.toString());
                MessageHeaders headers = message.getHeaders();
                Object tagObject = headers.get(AmqpHeaders.DELIVERY_TAG);
                if (tagObject != null) {
                    Long tag = (Long) tagObject;
                }
                Thread.sleep(1000L);
                System.out.println(Thread.currentThread().getName());
            }
        });
        //channel.basicAck(tag, false);
    }

    @RabbitListener(queues = {FANOUT_QUEUE_1_NAME})
    public void receiveMessageFromFanout1(Message message, Channel channel) throws InterruptedException {

        System.out.println("Received fanout 1 message: " + message.toString());
        MessageHeaders headers = message.getHeaders();
        Object tagObject = headers.get(AmqpHeaders.DELIVERY_TAG);
        if (tagObject != null) {
            Long tag = (Long) tagObject;
        }
        Thread.sleep(3000L);
        System.out.println(Thread.currentThread().getName());
        //channel.basicAck(tag, false);
    }

    @SneakyThrows
    @RabbitListener(queues = {FANOUT_QUEUE_2_ASYN_NAME})
    public void receiveMessageFromAsynFanout2(Message message, Channel channel) {
        taskExecutor.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("Received fanout 2 message: " + message);
                MessageHeaders headers = message.getHeaders();
                Long tag = (Long) headers.get(AmqpHeaders.DELIVERY_TAG);
                //channel.basicAck(tag, false);
                System.out.println(Thread.currentThread().getName());
            }
        });
    }

    @SneakyThrows
    @RabbitListener(queues = {FANOUT_QUEUE_2_NAME})
    public void receiveMessageFromFanout2(Message message, Channel channel) {
        System.out.println("Received fanout 2 message: " + message);
        MessageHeaders headers = message.getHeaders();
        Long tag = (Long) headers.get(AmqpHeaders.DELIVERY_TAG);
        //channel.basicAck(tag, false);
        System.out.println(Thread.currentThread().getName());
    }

    @RabbitListener(queues = {TOPIC_QUEUE_1_NAME})
    public void receiveMessageFromTopic1(String message) {
        System.out.println("Received topic 1 (" + BINDING_PATTERN_IMPORTANT + ") message: " + message);
    }

    @RabbitListener(queues = {TOPIC_QUEUE_2_NAME})
    public void receiveMessageFromTopic2(String message) {
        System.out.println("Received topic 2 (" + BINDING_PATTERN_ERROR + ") message: " + message);
    }
}
