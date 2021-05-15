package com.kevin.rpc.register.zookeeper;

import com.kevin.rpc.api.entity.RrcUrl;
import com.alibaba.fastjson.JSONObject;
import com.kevin.rpc.register.RemoteRegister;

import java.util.List;
import java.util.Random;

public class ZookeepRemoteRegister implements RemoteRegister {

    private ZookeeperClient client;

    public ZookeepRemoteRegister(ZookeeperClient zookeeperClient) {
        this.client = zookeeperClient;
    }

    public void register(String interfaceName, RrcUrl host) {
        try {
            StringBuilder nodePath = new StringBuilder("/");
            nodePath.append(interfaceName).append("/").append(JSONObject.toJSONString(host));
            if (client.started()) {
                client.createNodePath(nodePath.toString(), "111");
            }
        } catch (Exception e) {

        }
    }

    public RrcUrl getRadomURL(String interfaceName) {
        try {
            StringBuilder nodepath = new StringBuilder("/");
            nodepath.append(interfaceName);
            List<RrcUrl> urls = client.getChildNodes(nodepath.toString());
            Random random = new Random();
            int i = random.nextInt(urls.size());
            return urls.get(i);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}