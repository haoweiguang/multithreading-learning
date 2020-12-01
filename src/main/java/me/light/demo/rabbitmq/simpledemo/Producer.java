package me.light.demo.rabbitmq.simpledemo;

import com.rabbitmq.client.Address;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author light.hao
 * @date 2020/6/24 3:23 PM
 */
@Slf4j
public class Producer {
    private static final String QUEUE_NAME = "demo-queue";

    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        //创建连接
        Connection connection = factory.newConnection(Address.parseAddresses("127.0.0.1"));
        //创建通道
        Channel channel = connection.createChannel();
        //创建队列
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);

        String message = "hello";
        channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
        log.info("Message sent: " + message);

        channel.close();
        connection.close();
    }
}
