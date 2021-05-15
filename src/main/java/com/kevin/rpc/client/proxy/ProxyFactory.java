package com.kevin.rpc.client.proxy;

import com.kevin.rpc.api.entity.Invocation;
import com.kevin.rpc.api.entity.RrcUrl;
import com.kevin.rpc.framework.protocal.Protocl;
import com.kevin.rpc.framework.protocal.ProtoclFactory;
import com.kevin.rpc.framework.protocal.ProtoclType;
import com.kevin.rpc.register.RegisterType;
import com.kevin.rpc.register.RemoteRegister;
import com.kevin.rpc.register.factory.RemoteRegisterFactory;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyFactory {
    public static <T> T getProxy(final ProtoclType protoclType, final RegisterType registerType, final Class interfaceClass) {
        return (T) Proxy.newProxyInstance(interfaceClass.getClassLoader(), new Class[]{interfaceClass}, new InvocationHandler() {
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Protocl protocl = ProtoclFactory.getProtocl(protoclType);
                Invocation invocation = new Invocation(interfaceClass.getName(), method.getName(), method.getParameterTypes(), args);
                RemoteRegister remoteRegister = RemoteRegisterFactory.getRemoteRegister(registerType);
                RrcUrl radomURL = remoteRegister.getRadomURL(interfaceClass.getName());
                System.out.println("调用地址host:" + radomURL.getHost() + ",port:" + radomURL.getPort());
                return protocl.invokeProtocl(radomURL, invocation);
            }
        });
    }
}
