package com.example.loginservice;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Login",version="1.0",description="Login service"))
public class LoginserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(LoginserviceApplication.class, args);
    }

}
