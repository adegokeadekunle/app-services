package com.example.demo.app;

import org.springframework.http.ResponseEntity;

import java.util.List;

public interface BlacklistService {
   ResponseEntity<BlackListDto> getBlackListedUser(Long userId);
    ResponseEntity<Blacklist> blacklistUser(Long userId);

}
