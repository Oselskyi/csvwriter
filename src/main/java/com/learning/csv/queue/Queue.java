package com.learning.csv.queue;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class Queue {
    public static final String HOST = "localhost";
    private Channel channel;

    public Queue(){
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost(HOST);

        try {
            Connection connection = factory.newConnection();
            channel = connection.createChannel();
        } catch (Exception exception){
            System.out.println(exception);
        }
    }
    public void createExchangeQueue(String queueName, String exchangeName, String exchangeType, String key){
        try {
            channel.queueDeclare(queueName, false, false, false, null);
            channel.exchangeDeclare(exchangeName, exchangeType);
            channel.queueBind(queueName, exchangeName, key);
        } catch (Exception e){
            System.out.println(e);
        }
    }
}
