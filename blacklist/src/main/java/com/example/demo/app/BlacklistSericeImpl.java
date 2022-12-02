package com.example.demo.app;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Service
public class BlacklistSericeImpl implements BlacklistService{

    private final BlacklistRepository blacklistRepository;

    @Override
    public ResponseEntity<BlackListDto> getBlackListedUser(Long userId) {

        Blacklist blacklist  = blacklistRepository.findById(userId).orElseThrow(()-> new IllegalArgumentException("Not a BlackListed User"));
        BlackListDto blacklistDto = BlackListDto.builder()
                .isBlacklisted(blacklist.isBlacklisted())
                .userId(blacklist.getId())
                .build();
        return ResponseEntity.ok(blacklistDto);
    }

    @Override
    public ResponseEntity<Blacklist> blacklistUser(Long userId) {
        Blacklist blacklist =blacklistRepository.findById(userId).orElseThrow(()-> new RuntimeException("user not found"));
        blacklist.setBlacklisted(true);
        blacklistRepository.save(blacklist);

        return ResponseEntity.ok( blacklist);
    }

}
