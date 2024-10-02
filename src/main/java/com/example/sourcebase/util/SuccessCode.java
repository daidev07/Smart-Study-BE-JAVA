package com.example.sourcebase.util;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
@NoArgsConstructor
@AllArgsConstructor
@Getter
public enum SuccessCode {
    CREATED(201, "Success Created" , HttpStatus.CREATED),
    DELETE_SUCCESSFUL(1012, "Delete successful", HttpStatus.OK),
    UPDATE_SUCCESSFUL(1013, "Update successful", HttpStatus.OK),
    GET_SUCCESSFUL(1010, "Get successful", HttpStatus.OK);
    int code;
    String message;
    HttpStatus httpStatus;
}
