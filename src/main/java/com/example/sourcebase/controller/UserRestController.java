package com.example.sourcebase.controller;

import com.example.sourcebase.domain.User;
import com.example.sourcebase.domain.dto.reqdto.user.RegisterReqDTO;
import com.example.sourcebase.domain.dto.resdto.user.UserResDTO;
import com.example.sourcebase.service.IUserService;
import com.example.sourcebase.util.ErrorCode;
import com.example.sourcebase.util.ResponseData;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import com.example.sourcebase.util.SuccessCode;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.Date;


@RestController
@AllArgsConstructor
@RequestMapping("api/users")
@FieldDefaults(level = lombok.AccessLevel.PRIVATE, makeFinal = true)
public class UserRestController {
    IUserService userService;

    @PostMapping
    public ResponseEntity<ResponseData<?>> register(@RequestBody RegisterReqDTO registerReqDTO) {
        return ResponseEntity.ok(
                ResponseData.builder()
                        .code(SuccessCode.CREATED.getCode())
                        .message(SuccessCode.CREATED.getMessage())
                        .data(userService.register(registerReqDTO))
                        .build());
    }
    @GetMapping("/{id}")
    public ResponseEntity<ResponseData<?>> getUserById(@PathVariable Long id) {
        return ResponseEntity.ok(
                ResponseData.builder()
                        .code(SuccessCode.GET_SUCCESSFUL.getCode())
                        .message(SuccessCode.GET_SUCCESSFUL.getMessage())
                        .data(userService.getUserById(id))
                        .build());
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseData<?>> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.ok(
                ResponseData.builder()
                        .code(SuccessCode.DELETE_SUCCESSFUL.getCode())
                        .message(SuccessCode.DELETE_SUCCESSFUL.getMessage())
                        .build());
    }
    @PatchMapping("/{id}")
    public ResponseEntity<ResponseData<?>> updateUser(@PathVariable Long id, @RequestBody RegisterReqDTO request) {
        return ResponseEntity.ok(
                ResponseData.builder()
                        .code(SuccessCode.UPDATE_SUCCESSFUL.getCode())
                        .message(SuccessCode.UPDATE_SUCCESSFUL.getMessage())
                        .data(userService.updateUser(id, request))
                        .build());
    }
}
