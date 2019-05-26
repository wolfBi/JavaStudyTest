package com.bjl.mq.activemq;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class MQConsumerImpl implements IMQConsumer{
    private static final String USER = ActiveMQConnectionFactory.DEFAULT_USER;
    private static final String PASSWORD = ActiveMQConnectionFactory.DEFAULT_PASSWORD;
    private static final String BROKER_URL = ActiveMQConnectionFactory.DEFAULT_BROKER_URL;

    ConnectionFactory factory;
    Connection connection;
    Session session;

    public void init(){
        try {
            factory = new ActiveMQConnectionFactory(USER,PASSWORD,BROKER_URL);
            connection = factory.createConnection();
            connection.start();
            session = connection.createSession(false,Session.AUTO_ACKNOWLEDGE);
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }

    ThreadLocal<MessageConsumer>  mqTl = new ThreadLocal<MessageConsumer>();
    ThreadLocal<Integer>  cTl = new ThreadLocal<Integer>();

    public void getMessage(String queueName){
        try {
            MessageConsumer consumer = mqTl.get();
            if(consumer == null){
                Queue queue =session.createQueue(queueName);
                consumer = session.createConsumer(queue);
                mqTl.set(consumer);
            }
            Integer count = cTl.get();
            if(count == null){
                count = 0;
            }

            while (true){
                TextMessage message = (TextMessage) consumer.receive();
                if(message != null){
                    count++;
                    message.acknowledge();
                    cTl.set(count);
                    System.out.println(Thread.currentThread().getName()+ " msg "+count+" getMessage = " + message.getText());
                }else{
                    System.out.println(Thread.currentThread().getName()+ " msg "+count+" over " );
                    break;
                }
            }
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
