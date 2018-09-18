package com.zhou.service;

import java.util.ServiceLoader;

public class SPITest {
    public static void main(String[] args) {
        ServiceLoader.load(LanService.class).forEach(LanService::sayLan);
    }
}
