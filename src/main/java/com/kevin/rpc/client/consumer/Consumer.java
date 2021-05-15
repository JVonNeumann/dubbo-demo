package com.kevin.rpc.client.consumer;

import com.kevin.rpc.api.HelloService;
import com.kevin.rpc.client.proxy.ProxyFactory;
import com.kevin.rpc.framework.protocal.ProtoclType;
import com.kevin.rpc.register.RegisterType;

public class Consumer {
    public static void main(String[] args) {
        //HelloService helloService = ProxyFactory.getProxy(ProtoclType.HTTP, RegisterType.ZOOKEEPER,HelloService.class);
        HelloService helloService = ProxyFactory.getProxy(ProtoclType.NETTY, RegisterType.ZOOKEEPER,HelloService.class);
        String result = helloService.sayHello("kevin");
        System.out.println(result);
    }
}
