package com.example.appservice;

import com.example.appservice.app.AppRepository;
import com.example.appservice.app.Application;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "App-service",version="1.0",description="sytycc - IGate"))
public class AppserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AppserviceApplication.class, args);
    }

    @Autowired
    private AppRepository appRepo;

    @PostConstruct
    public void init(){
        List<Application> apps = new ArrayList<>();
        apps.add(new Application(1L,AppServicesEnum.LOGIN_SERVICE));
        apps.add(new Application(2L,AppServicesEnum.REPORT_SERVICE));
        appRepo.saveAll(apps);
    }

}
