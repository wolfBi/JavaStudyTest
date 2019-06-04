package com.study.rmi;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class MainTest {

    public static void main(String[] args) {
        try {
            //生成Stub 和Skeleton
            //执行rimiregistry 命令注册服务
            //启动服务
            LocateRegistry.createRegistry(1098);
            Naming.bind("rmi://127.0.0.1:1098/GreetServer", new GreetServerImpl());
            //客户端调用
            IGreetServer greetServer = (IGreetServer) Naming.lookup("rmi://127.0.0.1:1098/GreetServer");
            System.out.println(greetServer.sayHello("娃哈哈"));
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (AlreadyBoundException e) {
            e.printStackTrace();
        } catch (NotBoundException e) {
            e.printStackTrace();
        }
    }
}
