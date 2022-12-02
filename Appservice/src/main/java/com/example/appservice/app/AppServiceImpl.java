package com.example.appservice.app;

import com.example.appservice.app.commonModels.Report;
import lombok.RequiredArgsConstructor;
import org.hibernate.usertype.ParameterizedType;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AppServiceImpl implements AppService {

    private final AppRepository appRepo;
    private final WebClient webClient;

    @Override
    public ResponseEntity<List<Report>> getService(AppServicesEnum service) {
        String uri = service.getService();


        List<Report> report = new ArrayList<> ();
        Report[] app= webClient.get()
                .uri(uri)
                .retrieve()
                .bodyToMono(Report[].class)
                .block();


        return new ResponseEntity<>(app,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<Application>> getAllService() {
        List<Application> app = appRepo.findAll();
        if (app.isEmpty()){
            throw new RuntimeException("There are no available service");
        }
        return new ResponseEntity(app, HttpStatus.OK);
    }
}
