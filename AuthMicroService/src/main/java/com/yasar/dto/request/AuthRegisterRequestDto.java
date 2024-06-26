package com.yasar.dto.request;

import jakarta.validation.constraints.Email;
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
public class AuthRegisterRequestDto {
    @Email
    @NotNull
    private String email;
    @NotNull
    @NotEmpty
    @Size(min = 3, max = 64)
    private String userName;
    @NotNull
    @NotEmpty
    @Size(min = 8, max = 32)
    private String password;
    @NotNull
    @NotEmpty
    @Size(min = 8, max = 32)
    private String rePassword;

}
