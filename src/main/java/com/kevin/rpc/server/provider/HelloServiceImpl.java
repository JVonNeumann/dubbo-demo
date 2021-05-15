package com.kevin.rpc.server.provider;

import com.kevin.rpc.api.HelloService;

public class HelloServiceImpl implements HelloService {
    public String sayHello(String name) {
        System.out.println("hello," + name);
        return "hello " + name;
    }
}
