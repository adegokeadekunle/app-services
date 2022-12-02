package com.example.demo.app;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Blacklist {

    @Id
    private Long id;
    private Long userId;
    private boolean isBlacklisted;

}
