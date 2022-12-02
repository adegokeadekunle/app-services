package com.example.demo.app;


import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BlackListDto {

    private Long userId;
    private boolean isBlacklisted;
}
