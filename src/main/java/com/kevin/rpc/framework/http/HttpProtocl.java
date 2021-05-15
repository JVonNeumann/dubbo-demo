package com.kevin.rpc.framework.http;

import com.kevin.rpc.api.entity.Invocation;
import com.kevin.rpc.api.entity.RrcUrl;
import com.kevin.rpc.framework.protocal.Protocl;
import com.kevin.rpc.framework.http.client.HttpClient;

public class HttpProtocl implements Protocl {

    public Object invokeProtocl(RrcUrl url, Invocation invocation) {
        HttpClient httpClient = new HttpClient();
        return httpClient.post(url.getHost(), url.getPort(), invocation);
    }

    public void start(RrcUrl url) {
        HttpServer httpServer = new HttpServer();
        httpServer.start(url.getHost(), url.getPort());
    }
}