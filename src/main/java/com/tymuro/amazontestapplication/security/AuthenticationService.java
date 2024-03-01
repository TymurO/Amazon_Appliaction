package com.tymuro.amazontestapplication.security;

import com.tymuro.amazontestapplication.dto.AuthResponseDto;
import com.tymuro.amazontestapplication.dto.LoginDto;
import com.tymuro.amazontestapplication.dto.RegisterDto;
import com.tymuro.amazontestapplication.models.Role;
import com.tymuro.amazontestapplication.models.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserService userService;

    private final JwtService jwtService;

    private final PasswordEncoder passwordEncoder;

    private final AuthenticationManager authenticationManager;

    public ResponseEntity<?> signUp(RegisterDto registerDtoDto) {
        if (userService.getUserByUsername(registerDtoDto.getUsername()) != null) {
            return ResponseEntity.status(400).body("Username is taken");
        }
        if (!registerDtoDto.getPassword().equals(registerDtoDto.getConfirmPassword())) {
            return ResponseEntity.status(400).body("Passwords don't match");
        }
        UserEntity user = new UserEntity();
        user.setUsername(registerDtoDto.getUsername());
        user.setPassword(passwordEncoder.encode(registerDtoDto.getPassword()));
        user.setRoles(List.of(new Role("USER")));

        userService.create(user);

        return ResponseEntity.ok("User create success");
    }

    public ResponseEntity<AuthResponseDto> signIn(LoginDto loginDto) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginDto.getUsername(), loginDto.getPassword()));
        UserEntity user = userService.getUserByUsername(loginDto.getUsername());
        String token = jwtService.generateToken(user);

        return ResponseEntity.ok(new AuthResponseDto(token));
    }
}
