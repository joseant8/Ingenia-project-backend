package com.ingenia.security;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootTest
public class SecurityTest {

    @Autowired
    PasswordEncoder encoder;

    @Test
    @DisplayName("Codificar password")
    public void encodePassword() {
        String password = "ingenia01";
        String passwordCodificada = encoder.encode(password);
        //System.out.println("Password codificada: " + passwordCodificada);
    }
}
