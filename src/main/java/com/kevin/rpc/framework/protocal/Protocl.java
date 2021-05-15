package com.kevin.rpc.framework.protocal;

import com.kevin.rpc.api.entity.Invocation;
import com.kevin.rpc.api.entity.RrcUrl;

public interface Protocl {
    /**
     * 远程调用
     *
     * @param url
     * @param invocation
     */
    Object invokeProtocl(RrcUrl url, Invocation invocation);

    /**
     * 服务开启
     *
     * @param url
     */
    void start(RrcUrl url);
}
