package com.example.appservice.app;

import com.example.appservice.app.commonModels.Report;
import com.example.appservice.app.commonModels.ReportDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("/api/v1/appservice")
@RequiredArgsConstructor
public class AppController {

    private final AppService appService;

    @GetMapping("/get-service/{reportId}")
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<ReportDto>  getService(@PathVariable Long reportId){
        System.out.println("hello");
        return appService.getService(reportId);
    }
@GetMapping("/getAllReports")
    ResponseEntity<List<ReportDto>> getAllReports(){
        return appService.getAllReports();
}

    @GetMapping("/get-all-services")
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<List<Application>> getAllService(){
        return appService.getAllService();
    }



}
