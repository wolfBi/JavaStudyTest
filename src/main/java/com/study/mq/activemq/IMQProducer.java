package com.study.mq.activemq;

public interface IMQProducer {
    void init();
    void sendMessage(String queueName);
}
