package com.study.design.proxy;

/**
 *  代理类
 *  轻量级对象，创建很快
 */
public class DBQueryProxy implements IDBQuery {
    private DBQuery real = null;

    public String request() {
        //真正调用方法时，才会创建真实的类
        if(real == null)
            real = new DBQuery();
        //在多线程环境下，这里返回虚假的类，类似Future模式
        return real.request();
    }
}
