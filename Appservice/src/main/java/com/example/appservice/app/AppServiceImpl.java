package com.example.appservice.app;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AppServiceImpl implements AppService {

    private final AppRepository appRepo;
    private final WebClient webClient;

    @Override
    public ResponseEntity<Application> getService(AppServicesEnum service) {
        String uri = service.getService();

        Application app= webClient.get()
                .uri(uri)
                .retrieve()
                .bodyToMono(Application.class)
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
