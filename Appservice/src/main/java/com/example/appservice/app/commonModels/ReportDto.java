package com.example.appservice.app.commonModels;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReportDto {
    private String message;
    private String author;
}
