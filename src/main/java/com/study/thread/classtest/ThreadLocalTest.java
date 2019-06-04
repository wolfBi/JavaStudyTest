package com.study.thread.classtest;


import javax.jms.Session;

public class ThreadLocalTest {
    private static final ThreadLocal threadLocal = new ThreadLocal();
    public static Session getSession(){
        Session s = (Session) threadLocal.get();
        try{
            if(s==null){
                //s = new Object();
                threadLocal.set(s);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return s;
    }
}
