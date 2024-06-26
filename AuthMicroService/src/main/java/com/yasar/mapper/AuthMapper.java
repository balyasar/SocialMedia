package com.yasar.mapper;

import com.yasar.dto.request.AuthLoginRequestDto;
import com.yasar.dto.request.AuthRegisterRequestDto;
import com.yasar.entity.Auth;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AuthMapper {
    AuthMapper INSTANCE = Mappers.getMapper(AuthMapper.class);

    Auth fromAuthRegisterDto(AuthRegisterRequestDto dto);

    Auth fromAuthLoginDto(AuthLoginRequestDto dto);
}
