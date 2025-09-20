package com.alasala.sis.studentInformationSystem.security;

import com.alasala.sis.studentInformationSystem.dto.LoginRequestDto;
import com.alasala.sis.studentInformationSystem.dto.LoginResponseDto;
import com.alasala.sis.studentInformationSystem.dto.SignUpResponseDto;
import com.alasala.sis.studentInformationSystem.entity.User;
import com.alasala.sis.studentInformationSystem.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final AuthenticationManager authenticationManager;
    private final AuthUtil authUtil;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public LoginResponseDto login(LoginRequestDto loginRequestDto) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequestDto.getUsername(), loginRequestDto.getPassword())
        );
        User user = (User) authentication.getPrincipal();
        String token = authUtil.generateAccessToken(user);

        return new LoginResponseDto(token,user.getId());
    }

    public SignUpResponseDto signUp(LoginRequestDto signupRequestDto) {
        User user = userRepository.findByUsername(signupRequestDto.getUsername()).orElse(null);
        if (user != null)
            throw new IllegalArgumentException("User with this UserName Already Existed: "+signupRequestDto.getUsername());

        User newUser = userRepository.save(User.builder()
                .username(signupRequestDto.getUsername())
                .password(passwordEncoder.encode(signupRequestDto.getPassword()))
                .build()
        );
        return new SignUpResponseDto(newUser.getId(), newUser.getUsername());
    }
}
