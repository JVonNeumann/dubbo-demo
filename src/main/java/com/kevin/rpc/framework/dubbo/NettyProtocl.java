package com.kevin.rpc.framework.dubbo;

import com.kevin.rpc.api.entity.Invocation;
import com.kevin.rpc.api.entity.RrcUrl;
import com.kevin.rpc.framework.protocal.Protocl;
import com.kevin.rpc.framework.dubbo.client.NettyClient;

public class NettyProtocl implements Protocl {
    public Object invokeProtocl(RrcUrl url, Invocation invocation) {
        NettyClient nettyClient = new NettyClient();
        return nettyClient.send(url.getHost(),url.getPort(),invocation);
    }

    public void start(RrcUrl url) {
        NettyServer nettyServer = new NettyServer();
        nettyServer.start(url.getHost(),url.getPort());
    }
}
