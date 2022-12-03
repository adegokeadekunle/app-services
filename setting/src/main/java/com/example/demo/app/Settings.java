package com.example.demo.app;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class Settings {

    @Id
    private Long settingId;
    private String serviceName;
    private String location;
    private String configuration;
}
