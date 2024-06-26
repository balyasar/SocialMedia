package com.yasar.service;

import com.yasar.config.JwtManager;
import com.yasar.dto.request.AuthLoginRequestDto;
import com.yasar.dto.request.AuthRegisterRequestDto;
import com.yasar.dto.request.UserProfileCreateRequestDto;
import com.yasar.entity.Auth;
import com.yasar.exception.AuthException;
import com.yasar.exception.ErrorType;
import com.yasar.manager.UserProfileManager;
import com.yasar.mapper.AuthMapper;
import com.yasar.repository.AuthRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final AuthRepository repository;
    private final UserProfileManager userProfileManager;
    private final JwtManager jwtManager;

    public void save(AuthRegisterRequestDto dto) {
        Auth auth = repository.save(AuthMapper.INSTANCE.fromAuthRegisterDto(dto));
        userProfileManager.createProfile(UserProfileCreateRequestDto.builder()
                .authId(auth.getId())
                .userName(auth.getUserName())
                .build());
    }

    public String login(AuthLoginRequestDto dto) {
        Optional<Auth> optionalAuth = repository
                .findOptionalByUserNameAndPassword(dto.getUserName(), dto.getPassword());
        if (optionalAuth.isEmpty())
            throw new AuthException(ErrorType.BAD_REQUEST_USERNAME_OR_PASSWORD_ERROR);
        return jwtManager.createToken(optionalAuth.get().getId());
    }
}
