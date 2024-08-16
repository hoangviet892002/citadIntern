package com.hdbank.Citad.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.Key;

@Configuration
public class HmacConfig {

    @Bean
    public Key HmacKey() {
       try {
           KeyGenerator keyGenerator = KeyGenerator.getInstance("HmacSHA256");
           return keyGenerator.generateKey();
       } catch (Exception e) {
           throw new RuntimeException("Failed to generate HMAC key", e);
       }

    }
}
