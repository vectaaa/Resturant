package com.example.resturant;

import com.example.resturant.controller.RestaurantController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.io.File;
import java.util.Arrays;


@SpringBootApplication
//@EnableSwagger2
public class ResturantApplication {


    @Bean
    CorsConfigurationSource corsConfigurationSource()
    {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("*"));
        //or any domain that you want to restrict to
        configuration.setAllowedHeaders(Arrays.asList("*"));
        configuration.setAllowedMethods(Arrays.asList("*"));
        //Add the method support as you like
        UrlBasedCorsConfigurationSource source = new     UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
    public static void main(String[] args) {

        // Below line will create "uploads" folder at startup if not created.
//        new File(RestaurantController.uploadDirectory).mkdir();
        SpringApplication.run(ResturantApplication.class, args);
    }

}
