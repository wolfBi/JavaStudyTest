package com.study.design.singleton;
//双重检测，线程安全，延迟加载，效率较好
public class SyncSingleton {
    private SyncSingleton() {
        System.out.println("SyncSingleton is create");
    }
    private static SyncSingleton instance = null;
    public static SyncSingleton getInstance() {
       if(instance == null){
           synchronized(SyncSingleton.class){
               if(instance == null){
                   instance = new SyncSingleton();
               }
           }
       }
       return instance;
    }
}
