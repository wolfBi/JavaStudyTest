package com.bjl.mq.activemq;

public interface IMQConsumer {
    void init();
    void getMessage(String queueName);
}
