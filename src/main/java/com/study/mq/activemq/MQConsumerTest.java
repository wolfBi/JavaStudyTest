package com.study.mq.activemq;


public class MQConsumerTest {

    private static final String QUEUENAME = "TEST-1";
    public static void main(String[] args) {
        IMQConsumer consumer = new MQConsumerImpl();
        consumer.init();

        MQConsumerTest test = new MQConsumerTest();
        new Thread(test.new MyThread(consumer)).start();
        new Thread(test.new MyThread(consumer)).start();
        new Thread(test.new MyThread(consumer)).start();
        new Thread(test.new MyThread(consumer)).start();
        new Thread(test.new MyThread(consumer)).start();

    }

    private class MyThread implements Runnable{
        private IMQConsumer consumer;
        public MyThread(IMQConsumer consumer){
            this.consumer = consumer;
        }
        public void run() {
            while (true){
                consumer.getMessage(QUEUENAME);
                try {
                    Thread.sleep(500);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
    }
}
