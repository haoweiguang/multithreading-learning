package me.light.demo.rabbitmq.simpledemo;

import com.rabbitmq.client.*;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author light.hao
 * @date 2020/6/24 3:37 PM
 */
@Slf4j
public class DemoConsumer {
    private static final String QUEUE_NAME = "demo-queue";

    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        Connection connection = factory.newConnection(Address.parseAddresses("127.0.0.1"));
        Channel channel = connection.createChannel();

        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        Consumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope,
                                       AMQP.BasicProperties properties, byte[] body) {
                log.info("Message received: " + new String(body));
            }
        };

        channel.basicConsume(QUEUE_NAME, true, consumer);
    }
}
