package com.study.design.singleton;

public class Singleton {
    public static int STATUS=1;
    private Singleton(){
        System.out.println("Singleton is create");
        System.out.println(STATUS);
    }
    private static Singleton instance = new Singleton();
    public static Singleton getInstance() {
        return  instance;
    }
}
