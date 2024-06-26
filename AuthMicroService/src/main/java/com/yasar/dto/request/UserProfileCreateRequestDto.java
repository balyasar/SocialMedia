package com.yasar.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // get, set, toString
@AllArgsConstructor // parametreli constructorların tümü
@NoArgsConstructor // default constructor
@Builder
public class UserProfileCreateRequestDto {
    @NotNull
    @Min(value = 1)
    private Long authId;
    @NotNull
    @NotEmpty
    @Size(min = 3, max = 64)
    private String userName;
}
