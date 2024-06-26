package com.yasar.mapper;

import com.yasar.dto.request.UserProfileCreateRequestDto;
import com.yasar.document.UserProfile;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserProfileMapper {
    UserProfileMapper INSTANCE = Mappers.getMapper(UserProfileMapper.class);

    UserProfile fromUserProfileCreateDto(UserProfileCreateRequestDto dto);
}
