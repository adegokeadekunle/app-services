package com.example.appservice.app;

import com.example.appservice.app.commonModels.Report;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface AppService {
    ResponseEntity<List<Report>> getService(AppServicesEnum service);
    ResponseEntity<List<Application>> getAllService();
}
