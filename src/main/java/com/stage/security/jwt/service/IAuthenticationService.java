package com.stage.security.jwt.service;

import com.stage.security.jwt.dto.JwtAuthenticationResponse;
import com.stage.security.jwt.dto.LoginRequest;
import com.stage.security.jwt.dto.RegisterRequest;
import com.stage.security.jwt.model.User;

public interface IAuthenticationService {
    User register(RegisterRequest registerRequest);
    public JwtAuthenticationResponse login(LoginRequest loginRequest);
}
