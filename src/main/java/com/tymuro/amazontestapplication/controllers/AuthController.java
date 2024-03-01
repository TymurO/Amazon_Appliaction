package com.tymuro.amazontestapplication.controllers;

import com.tymuro.amazontestapplication.dto.AuthResponseDto;
import com.tymuro.amazontestapplication.dto.LoginDto;
import com.tymuro.amazontestapplication.dto.RegisterDto;
import com.tymuro.amazontestapplication.models.Role;
import com.tymuro.amazontestapplication.models.UserEntity;
import com.tymuro.amazontestapplication.repositories.UserRepository;
import com.tymuro.amazontestapplication.security.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {

    private final AuthenticationService authenticationService;


    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterDto registerDto) {
//        if (userRepository.existsByUsername(registerDto.getUsername())) {
//            return ResponseEntity.status(400).body("Username is taken");
//        }
//        else if (!registerDto.getPassword().equals(registerDto.getConfirmPassword())) {
//            return ResponseEntity.status(400).body("Passwords don't match");
//        }
//
//        UserEntity user = new UserEntity();
//        user.setUsername(registerDto.getUsername());
//        user.setPassword(passwordEncoder.encode(registerDto.getPassword()));
//        user.setRoles(List.of(new Role("USER")));
//
//        userRepository.save(user);
//
//        return ResponseEntity.ok().body("User registered success");
        return authenticationService.signUp(registerDto);
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponseDto> login(@RequestBody LoginDto loginDto) {
//        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginDto.getUsername(), loginDto.getPassword()));
//        SecurityContextHolder.getContext().setAuthentication(authentication);
//        UserEntity user = userRepository.findUserEntityByUsername(loginDto.getUsername()).orElseThrow();
//        String token = jwtUtils.generateToken(user);
//        return new ResponseEntity<>(new AuthResponseDto(token), HttpStatus.OK);
        return authenticationService.signIn(loginDto);
    }
}
