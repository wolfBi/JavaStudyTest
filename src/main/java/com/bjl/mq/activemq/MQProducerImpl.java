package com.bjl.mq.activemq;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class MQProducerImpl implements IMQProducer{

    ConnectionFactory factory = null;
    Connection connection = null;
    Session session = null;

    public void init(){
        try {
            factory = new ActiveMQConnectionFactory(ActiveMQConnectionFactory.DEFAULT_USER,ActiveMQConnectionFactory.DEFAULT_PASSWORD,ActiveMQConnectionFactory.DEFAULT_BROKER_URL);
            connection = factory.createConnection();
            connection.start();
            session = connection.createSession(true,Session.AUTO_ACKNOWLEDGE);
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }

    ThreadLocal<MessageProducer>  mqTl = new ThreadLocal<MessageProducer>();
    ThreadLocal<Integer>  cTl = new ThreadLocal<Integer>();

    public void sendMessage(String queueName){
        try {
            MessageProducer producer = mqTl.get();
            if(producer == null){
                Queue queue =session.createQueue(queueName);
                producer = session.createProducer(queue);
                mqTl.set(producer);
            }
            String mes;
            TextMessage message;
            Integer count = cTl.get();
            if(count == null){
                count = 0;
            }
            while (count<200){
                count++;
                mes = Thread.currentThread().getName()+"就是为了测试MQProducer "+count;
                message = session.createTextMessage(mes);
                producer.send(message);
                System.out.println("producer = [" + mes + "]");
                cTl.set(count);
                session.commit();

            }
        } catch (JMSException e) {
            e.printStackTrace();
        }

    }
}
