package com.bjl.rmi;


import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * 实现远程接口，继承UnicastRemoteObject 类
 */
public class GreetServerImpl extends UnicastRemoteObject implements IGreetServer {

    public GreetServerImpl() throws RemoteException {
        super();
    }

    public String sayHello(String name) throws RemoteException{
        return "Hello "+name;
    }
}
