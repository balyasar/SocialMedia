package com.yasar.service;

import com.yasar.config.JwtManager;
import com.yasar.dto.request.UserProfileCreateRequestDto;
import com.yasar.document.UserProfile;
import com.yasar.exception.ErrorType;
import com.yasar.exception.UserProfileException;
import com.yasar.mapper.UserProfileMapper;
import com.yasar.repository.UserProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserProfileService {
    private final UserProfileRepository repository;
    private final JwtManager jwtManager;

    public Boolean save(UserProfileCreateRequestDto dto) {
        repository.save(UserProfileMapper.INSTANCE.fromUserProfileCreateDto(dto));
        return true;
    }

    public List<UserProfile> getAll(String token) {
        Optional<Long> authId = jwtManager.getAuthId(token);
        if (authId.isEmpty())
            throw new UserProfileException(ErrorType.INVALID_TOKEN_ERROR);
        Optional<UserProfile> optionalUser = repository.findOptionalByAuthId(authId.get());
        if (optionalUser.isEmpty())
            throw new UserProfileException(ErrorType.INVALID_AUTHID_ERROR);
        return repository.findAll();
    }
}
