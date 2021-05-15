package com.kevin.rpc.register.factory;

import com.kevin.rpc.register.RegisterType;
import com.kevin.rpc.register.RemoteRegister;
import com.kevin.rpc.register.remote.RemoterMapRegister;
import com.kevin.rpc.register.zookeeper.ZookeepRemoteRegister;
import com.kevin.rpc.register.zookeeper.ZookeeperClient;

public class RemoteRegisterFactory {
    private static RemoterMapRegister remoterMapRegister = new RemoterMapRegister();
    private static ZookeepRemoteRegister zookeepRemoteRegister = new ZookeepRemoteRegister(new ZookeeperClient());
    public static RemoteRegister getRemoteRegister(RegisterType registerType){
        switch (registerType){
            case LOCAL:return remoterMapRegister;
            case ZOOKEEPER: return zookeepRemoteRegister;
            default:return null;
        }
    }
}
