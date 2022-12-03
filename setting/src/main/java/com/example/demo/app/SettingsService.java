package com.example.demo.app;

import org.springframework.http.ResponseEntity;

public interface SettingsService {
    ResponseEntity<SettingsDto> getSettings(Long settingsId);
}
