package com.study.mq.activemq;


public class MQProducerTest {

    private static final String QUEUENAME = "TEST-1";
    public static void main(String[] args) {
        IMQProducer producer = new MQProducerImpl();
        producer.init();
//        producer.sendMessage(QUEUENAME);
        MQProducerTest test = new MQProducerTest();
        new Thread(test.new MyThread(producer)).start();
        new Thread(test.new MyThread(producer)).start();
        new Thread(test.new MyThread(producer)).start();
        new Thread(test.new MyThread(producer)).start();
        new Thread(test.new MyThread(producer)).start();
        new Thread(test.new MyThread(producer)).start();
        new Thread(test.new MyThread(producer)).start();
        new Thread(test.new MyThread(producer)).start();

    }

    private class MyThread implements Runnable{
        private IMQProducer producer;
        public MyThread(IMQProducer producer){
            this.producer = producer;
        }
        public void run() {
            while (true){
                producer.sendMessage(QUEUENAME);
                try {
                    Thread.sleep(500);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
    }
}
