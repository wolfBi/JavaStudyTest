package com.study.design.flyweight;

import com.study.design.proxy.DBQueryProxy;
import com.study.design.proxy.IDBQuery;

/**
 * 享元模式是少有的提升系统性能为目的的模式之一
 * 核心思想是如果一个系统中存在多个相同的对象，那么只需共享一份对象的拷贝，而不必每次都创建新的对象
 * 享元工厂，抽象享元，具体享元类，
 */
public class Main {
    public static void main(String[] args) {
        IDBQuery q = new DBQueryProxy(); //使用代理
        q.request();//真正使用时，才会创建真实对象
    }
}
