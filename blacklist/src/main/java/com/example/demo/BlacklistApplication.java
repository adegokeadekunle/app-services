package com.example.demo;

import com.example.demo.app.Blacklist;
import com.example.demo.app.BlacklistRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class BlacklistApplication {

	@Autowired
	private BlacklistRepository blacklistRepository;

	public static void main(String[] args) {
		SpringApplication.run(BlacklistApplication.class, args);
	}

	@PostConstruct
	public void blacklistListInit(){
		List<Blacklist> blacklist = new ArrayList<>();
		blacklist.add(new Blacklist(1L,1L,true));
		blacklist.add(new Blacklist(2L,2L,true));
		blacklist.add(new Blacklist(3L,3L,true));
		blacklist.add(new Blacklist(4L,4L,true));
		blacklistRepository.saveAllAndFlush(blacklist);

	}

}
