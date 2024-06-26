package com.yasar.controller;

import com.yasar.dto.request.UserProfileCreateRequestDto;
import com.yasar.document.UserProfile;
import com.yasar.service.UserProfileService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.yasar.config.RestApis.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(USER_PROFILE)
public class UserProfileController {
    private final UserProfileService service;

    @PostMapping(CREATE_PROFILE)
    public ResponseEntity<Boolean> createProfile(@RequestBody @Valid UserProfileCreateRequestDto dto) {
        return ResponseEntity.ok(service.save(dto));
    }

    @GetMapping(GET_ALL)
    public ResponseEntity<List<UserProfile>> getAll(String token) {
        return ResponseEntity.ok(service.getAll(token));
    }
}
