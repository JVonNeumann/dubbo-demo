package com.kevin.rpc.framework.protocal;

import com.kevin.rpc.framework.dubbo.NettyProtocl;
import com.kevin.rpc.framework.http.HttpProtocl;

public class ProtoclFactory {
    private static NettyProtocl nettyProtocl = new NettyProtocl();
    private static HttpProtocl httpProtocl = new HttpProtocl();

    public static Protocl getProtocl(ProtoclType protoclType) {
        switch (protoclType) {
            case HTTP:
                return httpProtocl;
            case NETTY:
                return nettyProtocl;
            default:
                return null;
        }
    }
}
