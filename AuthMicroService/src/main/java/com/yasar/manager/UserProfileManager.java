package com.yasar.manager;

import com.yasar.dto.request.UserProfileCreateRequestDto;
import jakarta.validation.Valid;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import static com.yasar.config.RestApis.*;

@FeignClient(url = "http://localhost:9091/dev/v1/user-profile", name = "userProfileManager")
public interface UserProfileManager {

    @PostMapping(CREATE_PROFILE)
    ResponseEntity<Boolean> createProfile(@RequestBody UserProfileCreateRequestDto dto);
}
