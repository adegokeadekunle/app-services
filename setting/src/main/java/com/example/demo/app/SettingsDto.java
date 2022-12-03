package com.example.demo.app;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class SettingsDto {
    private String serviceName;
    private String location;
    private String configuration;
}
