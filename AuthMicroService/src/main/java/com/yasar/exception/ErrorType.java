package com.yasar.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public enum ErrorType {
    BAD_REQUEST_ERROR(1001, "Girilen bilgiler eksik ya da hatalıdır.", HttpStatus.BAD_REQUEST),
    BAD_REQUEST_REPASSWORD_ERROR(1002, "Girilen şifreler uyuşmuyor.", HttpStatus.BAD_REQUEST),
    BAD_REQUEST_USERNAME_OR_PASSWORD_ERROR(1003, "Kullanıcı adı ya da şifre hatalıdır..", HttpStatus.BAD_REQUEST),
    INTERNAL_SERVER_ERROR_NOT_FOUND_DATA(9997, "Sunucu Hatası : Liste getirilemedi. Lütfen tekrar deneyin.", HttpStatus.INTERNAL_SERVER_ERROR),
    INTERNAL_SERVER_ERROR(9998, "Sunucuda beklenmeyen bir hata oluştu. Lütfen tekrar deneyiniz.", HttpStatus.INTERNAL_SERVER_ERROR);


    private Integer code;
    private String message;
    private HttpStatus httpStatus;
}
