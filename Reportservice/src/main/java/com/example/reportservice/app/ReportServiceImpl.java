package com.example.reportservice.app;

import lombok.RequiredArgsConstructor;
import org.springframework.context.NoSuchMessageException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReportServiceImpl implements ReportService {

    private final ReportRepository reportRepository;
    @Override
    public ResponseEntity<Report> createReport(Report report) {
        Report newReport = Report.builder()
                .author(report.getAuthor())
                .message(report.getMessage())
                .build();
        reportRepository.save(newReport);

        return new ResponseEntity<>(newReport, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Report> getReport(Long reportId) {
        Report report = reportRepository.findById(reportId).orElseThrow( () -> new IllegalArgumentException("No record of such report"));
      //  ReportDto reportDto = mapToReport(report);

        return ResponseEntity.ok(report);
    }

    @Override
    public ResponseEntity<List<Report>> getAllReports() {

        List<Report> reports = reportRepository.findAll();
       // List<ReportDto> reportDto = reports.stream().map(this::mapToReport).toList();

        if (reports.isEmpty()){
            throw new NoSuchMessageException("No reports available");
        }
        return new ResponseEntity<>(reports,HttpStatus.OK);
    }
    private ReportDto mapToReport(Report report){
        return new ReportDto().builder()
                .author(report.getAuthor())
                .message(report.getMessage())
                .build();
    }
}
