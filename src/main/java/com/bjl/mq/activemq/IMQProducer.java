package com.bjl.mq.activemq;

public interface IMQProducer {
    void init();
    void sendMessage(String queueName);
}
