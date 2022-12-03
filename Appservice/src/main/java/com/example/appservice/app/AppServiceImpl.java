package com.example.appservice.app;

import com.example.appservice.app.commonModels.Report;
import com.example.appservice.app.commonModels.ReportDto;
import lombok.RequiredArgsConstructor;
import org.hibernate.usertype.ParameterizedType;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AppServiceImpl implements AppService {

    private final AppRepository appRepo;
    private final WebClient webClient ;

    @Override
    public ResponseEntity<ReportDto> getService(Long reportId) {
        String uri = "http://localhost:4003/api/v1/reports/get";


        Report app= webClient.get()
                .uri(uri,uriBuilder -> uriBuilder.queryParam("id",reportId).build())
                .retrieve()
                .bodyToMono(Report.class)
                .block();

        ReportDto report = new ReportDto();
        report.setMessage(app.getMessage());
        report.setAuthor(app.getAuthor());

        return new ResponseEntity<>(report,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<ReportDto>> getAllReports() {

        String uri = "http://localhost:4003/api/v1/reports/get-all";

        Report[] app= webClient.get()
                .uri(uri)
                .retrieve()
                .bodyToMono(Report[].class)
                .block();

      //  List<ReportDto> reportDtos = Arrays.stream(app).toList();
        List<ReportDto> reportDto =  Arrays.stream(app).map(this::mapToReport).toList();

        return new ResponseEntity<>(reportDto,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<Application>> getAllService() {
        List<Application> app = appRepo.findAll();
        if (app.isEmpty()){
            throw new RuntimeException("There are no available service");
        }
        return new ResponseEntity(app, HttpStatus.OK);
    }
    private ReportDto mapToReport(Report report){
        return new ReportDto().builder()
                .author(report.getAuthor())
                .message(report.getMessage())
                .build();
    }
}
