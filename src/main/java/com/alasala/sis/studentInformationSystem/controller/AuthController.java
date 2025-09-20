package com.alasala.sis.studentInformationSystem.controller;

import com.alasala.sis.studentInformationSystem.common.ApiResponse;
import com.alasala.sis.studentInformationSystem.common.ResponseBuilder;
import com.alasala.sis.studentInformationSystem.dto.LoginRequestDto;
import com.alasala.sis.studentInformationSystem.dto.LoginResponseDto;
import com.alasala.sis.studentInformationSystem.dto.SignUpResponseDto;
import com.alasala.sis.studentInformationSystem.security.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<ApiResponse<LoginResponseDto>> login(@RequestBody LoginRequestDto loginRequestDto){
        LoginResponseDto loginResponseDto = authService.login(loginRequestDto);
        return ResponseBuilder.success("Login Successful", loginResponseDto, HttpStatus.OK);
    }

    @PostMapping("/signup")
    public ResponseEntity<ApiResponse<SignUpResponseDto>> signUp(@RequestBody LoginRequestDto signupRequestDto){
        SignUpResponseDto ResponseDto = authService.signUp(signupRequestDto);
        return ResponseBuilder.success("SignUp Successful", ResponseDto, HttpStatus.OK);
    }
}
