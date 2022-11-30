package com.example.appservice.app;

import org.springframework.http.ResponseEntity;

import java.util.List;

public interface AppService {
    ResponseEntity<Application> getService(AppServicesEnum service);
    ResponseEntity<List<Application>> getAllService();
}
