package com.study.design.singleton;

public class SingletonTest {

    public static void main(String[] args) {
        Singleton s1 =Singleton.getInstance();
        Singleton s2 =Singleton.getInstance();
        System.out.println(s1 == s2);
        LazySingleton ls1 = LazySingleton.getInstance();
        LazySingleton ls2 = LazySingleton.getInstance();
        System.out.println(ls1 == ls2);
        StaticSingleton ss1 = StaticSingleton.getInstance();
        StaticSingleton ss2 = StaticSingleton.getInstance();
        System.out.println(ss1 == ss2);
    }
}
