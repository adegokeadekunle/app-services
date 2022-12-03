package com.example.appservice.app;

import com.example.appservice.app.commonModels.Report;
import com.example.appservice.app.commonModels.ReportDto;
import org.springframework.http.ResponseEntity;
import reactor.core.publisher.Mono;

import java.util.List;

public interface AppService {
    ResponseEntity<ReportDto> getService(Long reportId);
    ResponseEntity<List<ReportDto>> getAllReports();
    ResponseEntity<List<Application>> getAllService();
}
