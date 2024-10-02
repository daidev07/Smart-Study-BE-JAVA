package com.example.sourcebase.domain.dto.resdto.user;

import com.example.sourcebase.domain.enumeration.EGender;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
public class UserResDTO {
    Long id;
    String name;
    String email;
    String phoneNumber;
    String dob;
    EGender gender;
    String username;
    String password;
    String typeUser;
}
