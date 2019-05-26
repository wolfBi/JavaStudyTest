package com.bjl.design.proxy;

/**
 * 真实主题
 * 重量级对象，构造比较慢
 */
public class DBQuery implements IDBQuery {
    public DBQuery(){
        try{
            Thread.sleep(1000); // 模拟某些一下操作。例如获取数据库连接
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String request() {
        return "request string";
    }
}
