package com.kevin.rpc.register.factory;

import com.kevin.rpc.register.LocalRegister;
import com.kevin.rpc.register.RegisterType;
import com.kevin.rpc.register.local.LocalMapRegister;

public class LocalRegisterFactory {
    private static LocalMapRegister localMapRegister = new LocalMapRegister();

    public static LocalRegister getLocalRegister(RegisterType registerType) {
        switch (registerType) {
            case LOCAL:
                return localMapRegister;
            default:
                return null;
        }
    }
}
