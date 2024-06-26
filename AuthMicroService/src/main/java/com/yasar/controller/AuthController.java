package com.yasar.controller;

import com.yasar.dto.request.AuthLoginRequestDto;
import com.yasar.dto.request.AuthRegisterRequestDto;
import com.yasar.exception.AuthException;
import com.yasar.exception.ErrorType;
import com.yasar.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.yasar.config.RestApis.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(AUTH)
public class AuthController {
    private final AuthService service;

    @PostMapping(REGISTER)
    public ResponseEntity<Boolean> register(@RequestBody @Valid AuthRegisterRequestDto dto) {
        if (!dto.getPassword().equals(dto.getRePassword()))
            throw new AuthException(ErrorType.BAD_REQUEST_REPASSWORD_ERROR);
        service.save(dto);
        return ResponseEntity.ok(true);
    }

    @PostMapping(LOGIN)
    public ResponseEntity<String> login(@RequestBody @Valid AuthLoginRequestDto dto) {
        return ResponseEntity.ok(service.login(dto));
    }
}
