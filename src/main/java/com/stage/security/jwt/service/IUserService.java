package com.stage.security.jwt.service;

import org.springframework.security.core.userdetails.UserDetailsService;

public interface IUserService {
    UserDetailsService userDetailsService();
}
