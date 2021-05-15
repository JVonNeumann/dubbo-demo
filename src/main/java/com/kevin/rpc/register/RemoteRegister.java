package com.kevin.rpc.register;

import com.kevin.rpc.api.entity.RrcUrl;

/**
 * 主要是供消费者端根据服务名字找对应的地址发起远程调用
 */
public interface RemoteRegister {
    /**
     * 注册到远程注册中心
     *
     * @param interfaceName
     * @param host
     */
    void register(String interfaceName, RrcUrl host);

    /**
     * 根据服务名称获取调用者的地址信息
     *
     * @param interfaceName
     * @return
     */
    RrcUrl getRadomURL(String interfaceName);
}
