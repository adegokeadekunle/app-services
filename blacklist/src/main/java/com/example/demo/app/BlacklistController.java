package com.example.demo.app;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/blacklist")
public class BlacklistController {

    private final BlacklistService blacklistService;

    @PostMapping
    public ResponseEntity<BlackListDto> getBlackListedUser(@RequestParam Long userId){
        return blacklistService.getBlackListedUser(userId);
    }

    @GetMapping
    public ResponseEntity<Blacklist> blacklistUser(@RequestParam Long userId){
        return blacklistService.blacklistUser(userId);

    }

}
