package com.example.reportservice.app;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/reports")
@RequiredArgsConstructor
public class ReportController {

    private final ReportService reportService;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    ResponseEntity<Report> createReport(@RequestBody Report report){

        return reportService.createReport(report);
    }

    @GetMapping("/get")
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<Report> getReport(Long reportId){
        return reportService.getReport(reportId);
    }

    @GetMapping("/get-all")
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<List<Report>> getAllReports(){
        return reportService.getAllReports();

    }
}
