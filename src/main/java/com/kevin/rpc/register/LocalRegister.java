package com.kevin.rpc.register;

/**
 * 主要是供服务端自己在反射调用的时候根据服务名称找到对应的实现
 */
public interface LocalRegister {
    /**
     * @param interfaceName      接口名称
     * @param interfaceImplClass 接口实现类
     */
    void register(String interfaceName, Class interfaceImplClass);

    /**
     * 获取实现类
     *
     * @param interfaceName
     * @return
     */
    Class get(String interfaceName);
}
