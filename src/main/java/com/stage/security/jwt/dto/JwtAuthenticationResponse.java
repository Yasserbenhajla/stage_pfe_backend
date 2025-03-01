package com.stage.security.jwt.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;


@Getter
@AllArgsConstructor
public class JwtAuthenticationResponse {
    private String token;
    private  String role;
}
