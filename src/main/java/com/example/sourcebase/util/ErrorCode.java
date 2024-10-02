package com.example.sourcebase.util;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;

import javax.tools.Diagnostic;

@Getter
@AllArgsConstructor
@FieldDefaults(level = lombok.AccessLevel.PRIVATE, makeFinal = true)
public enum ErrorCode {
    USER_NOT_FOUND(404, "User Not Found", HttpStatus.NOT_FOUND),
    ROLE_NOT_FOUND(404, "Role Not Found", HttpStatus.NOT_FOUND),
    USER_NOT_EXISTS(409, "User Not Exists", HttpStatus.CONFLICT),
    ID_NOT_EXISTS(409, "Id Not Exists", HttpStatus.CONFLICT),
    ILLEGAL_STATE(400, "Wrong password or username", HttpStatus.BAD_REQUEST),
    ILLEGAL_ARGUMENT(409, "Email, Phone or Username Already Exists", HttpStatus.CONFLICT),
    VALIDATION_ERROR(400, "", HttpStatus.BAD_REQUEST),
    USERNAME_EXISTS(409, "Username Exists", HttpStatus.CONFLICT),
    ;
    int code;
    String message;
    HttpStatus httpStatus;
}
