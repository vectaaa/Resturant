package com.example.resturant.config;

import org.springframework.context.annotation.Configuration;

import java.util.Base64;

@Configuration
public class PasswordHashing {

    public String encryptPassword(String password) {
        return Base64.getEncoder().encodeToString(password.getBytes());
    }

    public String decryptPassword(String encryptedString) {
        return new String(Base64.getMimeDecoder().decode(encryptedString));
    }

//    public static void main(String[] args) {
//        String password = "23rrthgfe454333343";
//        String encrypted = encryptPassword(password);
//        System.out.println(encrypted);
//    }
}
