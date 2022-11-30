package com.example.reportservice;

import com.example.reportservice.app.Report;
import com.example.reportservice.app.ReportRepository;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "App-service",version="1.0",description="sytycc - IGate"))
public class ReportserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReportserviceApplication.class, args);
    }

    @Autowired
    private ReportRepository reportRepository;

    @PostConstruct
    public void init() {
        List<Report> reports = new ArrayList<>();
        reports.add(new Report(1l, "The server is up and running", "Adekunle", LocalDateTime.now(), LocalDateTime.now()));
        reports.add(new Report(2l, "making communication", "Peace", LocalDateTime.now(), LocalDateTime.now()));
        reports.add(new Report(3l, "ping from server", "Starr", LocalDateTime.now(), LocalDateTime.now()));
        reports.add(new Report(4l, "restart the DB", "White fang", LocalDateTime.now(), LocalDateTime.now()));
        reports.add(new Report(5l, "we are back up", "Kench", LocalDateTime.now(), LocalDateTime.now()));
        reportRepository.saveAll(reports);

    }
}
