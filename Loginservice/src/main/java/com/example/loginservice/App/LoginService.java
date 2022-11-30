package com.example.loginservice.App;

public interface LoginService {
    Login creatAccount(Login login);
    LoginResponse loginUser(String email, String password);
}
