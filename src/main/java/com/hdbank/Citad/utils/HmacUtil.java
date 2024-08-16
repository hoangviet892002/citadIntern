package com.hdbank.Citad.utils;

import org.springframework.stereotype.Component;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.util.Base64;


@Component
public class HmacUtil {

    private final Key key;

    private static final String HMACKey = "HmacKey";
    public HmacUtil(Key key) {
        this.key = key;
    }

    public String calculateHmac(String data) {
        try {
            Mac mac = Mac.getInstance("HmacSHA256");
            mac.init(new SecretKeySpec(key.getEncoded(), "HmacSHA256"));
            byte[] bytes = mac.doFinal(data.getBytes());
            return Base64.getEncoder().encodeToString(bytes);
        } catch (Exception e) {
            throw new RuntimeException("Failed to calculate HMAC", e);
        }
    }
    public boolean verifyHmac(String data) {
        return calculateHmac(data).equals(calculateHmac(HMACKey));
    }

}
