package com.example.appservice.app;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Application {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long AppId;
    @Enumerated(EnumType.STRING)
    private AppServicesEnum appService;

}
