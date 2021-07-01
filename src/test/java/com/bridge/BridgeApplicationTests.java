package com.bridge;

import com.bridge.common.utils.JwtUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootTest
class BridgeApplicationTests {

    @Test
    void contextLoads() {
        System.out.println(String.format("BI-%07d", 20 + 1));
    }

}
