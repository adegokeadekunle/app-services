package com.example.demo.app;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/settings")
public class SettingsController {
    private final SettingsService settings;

    @GetMapping("/get/{settingId}")
    ResponseEntity<SettingsDto> getSettings(@PathVariable Long settingsId){
        return settings.getSettings(settingsId);
    }

}
