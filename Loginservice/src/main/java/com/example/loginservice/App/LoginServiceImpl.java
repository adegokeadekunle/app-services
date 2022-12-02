package com.example.loginservice.App;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LoginServiceImpl implements LoginService{

    private final LoginRepository loginRepository;

    @Override
    public Login creatAccount(Login login) {
        Login log = Login.builder()
                .name(login.getName())
                .email(login.getEmail())
                .password(login.getPassword())
                .build();
        return loginRepository.save(log);
    }

    @Override
    public LoginResponse loginUser(String email, String password) {
        Optional<Login> login = loginRepository.findByEmailAndPassword(email,password);

        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setEmail(login.get().getEmail());
        loginResponse.setPassword(login.get().getPassword());
        return loginResponse;
    }
}
