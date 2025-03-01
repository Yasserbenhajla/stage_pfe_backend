package com.stage.security.jwt.service.impl;

import com.stage.security.jwt.dto.JwtAuthenticationResponse;
import com.stage.security.jwt.dto.LoginRequest;
import com.stage.security.jwt.dto.RegisterRequest;
import com.stage.security.jwt.model.Role;
import com.stage.security.jwt.model.User;
import com.stage.security.jwt.repository.IUserRepository;
import com.stage.security.jwt.service.IAuthenticationService;
import com.stage.security.jwt.service.IJwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements IAuthenticationService {

    private final IUserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final IJwtService jwtService;
    
    public User register(RegisterRequest registerRequest) {
        User user = new User();

        user.setFirstName(registerRequest.getFirstName());
        user.setLastName(registerRequest.getLastName());
        user.setEmail(registerRequest.getEmail());
        user.setPassword(passwordEncoder.encode(registerRequest.getPassword()));

        switch (registerRequest.getRole().toUpperCase()) {
            case "ADMIN":
                user.setRole(Role.ADMIN);
                break;
            case "TEACHER":
                user.setRole(Role.TEACHER);
                break;
            case "USER":
            default:
                user.setRole(Role.USER);
                break;
        }

        return userRepository.save(user);
    }



    public JwtAuthenticationResponse login(LoginRequest loginRequest) {
        // Authentifier l'utilisateur
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword())
        );

        // Récupérer l'utilisateur depuis la base de données
        User user = userRepository.findByEmail(loginRequest.getEmail())
                .orElseThrow(() -> new UsernameNotFoundException("Utilisateur non trouvé"));

        // Générer le token JWT
        String token = jwtService.generateToken(user);

        // Retourner le token et le rôle de l'utilisateur
        return new JwtAuthenticationResponse(token, user.getRole().name());
    }

}
