package com.example.demo.app;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SettingsServiceImpl implements SettingsService{
    private final SettingsRepository settingsRepository;
    @Override
    public ResponseEntity<SettingsDto> getSettings(Long settingsId) {
        Settings settings = settingsRepository.findById(settingsId).orElseThrow(()-> new IllegalArgumentException(("setings not found")));
        SettingsDto settingsDto = mapToSettings(settings);
        return  ResponseEntity.ok(settingsDto);
    }
    private SettingsDto mapToSettings(Settings setting){
        SettingsDto dto = new SettingsDto();
        dto.setConfiguration(setting.getConfiguration());
        dto.setLocation(setting.getLocation());
        dto.setServiceName(setting.getServiceName());
        return dto;
    }
}
