package com.example.sourcebase.domain.dto.reqdto.user;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserLoginReqDTO {
    String username;
    String password;
}
