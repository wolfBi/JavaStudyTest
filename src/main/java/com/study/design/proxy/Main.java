package com.study.design.proxy;

/**
 * 代理模式用于实现延迟加载，有效提升系统的启动速度，改善用户体验
 * 动态代理有JDK自带的动态代理，CGLIB,Javassist或者ASM库
 */
public class Main {
    public static void main(String[] args) {
        IDBQuery q = new DBQueryProxy(); //使用代理
        q.request();//真正使用时，才会创建真实对象
    }
}
