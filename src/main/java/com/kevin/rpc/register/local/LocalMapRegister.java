package com.kevin.rpc.register.local;

import com.kevin.rpc.register.LocalRegister;

import java.util.HashMap;
import java.util.Map;

public class LocalMapRegister implements LocalRegister {
    private Map<String, Class> registerMap = new HashMap<String,Class>(1024);
    public void register(String interfaceName, Class interfaceImplClass) {
        registerMap.put(interfaceName,interfaceImplClass);
    }

    public Class get(String interfaceName) {
        return registerMap.get(interfaceName);
    }
}
