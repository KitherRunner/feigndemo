package com.kither.provider;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.EnvironmentPBEConfig;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ProviderApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    public void encrypt() {
        StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
        EnvironmentPBEConfig pbeConfig = new EnvironmentPBEConfig();
        pbeConfig.setAlgorithm("PBEWithMD5AndDES"); // 几码算法，固定值
        pbeConfig.setPassword("kither"); // 盐值
        encryptor.setConfig(pbeConfig);
        String password = encryptor.encrypt("wcj1995720");// 需要加密的密码
        System.out.println(password);
    }
}
