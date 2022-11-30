package com.example.reportservice.app;

import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ReportService {

    ResponseEntity<Report> createReport(Report report);
    ResponseEntity<Report> getReport(Long reportId);
    ResponseEntity<List<Report>> getAllReports();

}
