package com.example.loginservice.App;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Login {
    @Id
    Long id;
    String name;
    @Column(nullable = false,
            unique = true,length=45)
    String email;
    String password;
}
