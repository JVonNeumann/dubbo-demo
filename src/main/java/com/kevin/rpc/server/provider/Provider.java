package com.kevin.rpc.server.provider;

import com.kevin.rpc.api.HelloService;
import com.kevin.rpc.api.entity.RrcUrl;
import com.kevin.rpc.framework.protocal.Protocl;
import com.kevin.rpc.framework.protocal.ProtoclFactory;
import com.kevin.rpc.framework.protocal.ProtoclType;
import com.kevin.rpc.register.LocalRegister;
import com.kevin.rpc.register.RegisterType;
import com.kevin.rpc.register.RemoteRegister;
import com.kevin.rpc.register.factory.LocalRegisterFactory;
import com.kevin.rpc.register.factory.RemoteRegisterFactory;

public class Provider {
    public static void main(String[] args) {
        RrcUrl url = new RrcUrl("localhost", 8021);
        //远程服务注册地址
        RemoteRegister register = RemoteRegisterFactory.getRemoteRegister(RegisterType.ZOOKEEPER);
        register.register(HelloService.class.getName(), url);

        //本地注册服务的实现类
        LocalRegister localRegister = LocalRegisterFactory.getLocalRegister(RegisterType.LOCAL);
        localRegister.register(HelloService.class.getName(), HelloServiceImpl.class);

        //这里我又封装了一层协议层，我们都知道dubbo有基于netty的dubbo协议，有基于http的http协议，还有基于redis的redis协议等等。
        //Protocl protocl = ProtoclFactory.getProtocl(ProtoclType.HTTP);
        Protocl protocl = ProtoclFactory.getProtocl(ProtoclType.NETTY);
        protocl.start(url);
    }
}
