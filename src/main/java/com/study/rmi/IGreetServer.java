package com.study.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * 创建接口，必须继承Remote
 */
public interface IGreetServer extends Remote {
    String sayHello(String name) throws RemoteException;
}
