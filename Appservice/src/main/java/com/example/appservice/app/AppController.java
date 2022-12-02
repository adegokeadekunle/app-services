package com.example.appservice.app;

import com.example.appservice.app.commonModels.Report;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/appservice")
@RequiredArgsConstructor
public class AppController {

    private final AppService appService;

    @GetMapping("/get-service")
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<Report> getService(@RequestParam("app-service") AppServicesEnum service){
        return appService.getService(service);
    }

    @GetMapping("/get-all-services")
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<List<Application>> getAllService(){
        return appService.getAllService();
    }



}
