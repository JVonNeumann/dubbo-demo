package com.kevin.rpc.framework.dubbo;

import com.kevin.rpc.api.entity.Invocation;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import com.kevin.rpc.register.RegisterType;
import com.kevin.rpc.register.factory.LocalRegisterFactory;

import java.lang.reflect.Method;

public class NettyChannelHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        Invocation invocation = (Invocation) msg;
        String interfaceName = invocation.getInterfaceName();
        Class interfaceImplClass = LocalRegisterFactory.getLocalRegister(RegisterType.LOCAL).get(interfaceName);
        Method method = interfaceImplClass.getMethod(invocation.getMethodName(), invocation.getParamtypes());
        String result = (String) method.invoke(interfaceImplClass.newInstance(), invocation.getObjects());
        ctx.write(result);
        ctx.flush();
    }
}