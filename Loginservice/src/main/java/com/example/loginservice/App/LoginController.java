package com.example.loginservice.App;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/loginService")
public class LoginController {
    private final LoginServiceImpl loginServiceImpl;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void creatAccount(@RequestBody Login login){
        loginServiceImpl.creatAccount(login);
    }

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    public LoginResponse login(@RequestBody LoginResponse loginResponse){
        loginServiceImpl.loginUser(loginResponse.getEmail(),loginResponse.getPassword());
        return loginResponse;
    }
}
