package com.example.sourcebase.service;

import com.example.sourcebase.domain.dto.reqdto.user.RegisterReqDTO;
import com.example.sourcebase.domain.dto.reqdto.user.UserLoginReqDTO;
import com.example.sourcebase.domain.dto.resdto.user.UserResDTO;
import com.example.sourcebase.util.ResponseData;
import org.springframework.stereotype.Service;

import java.util.UUID;
@Service
public interface IUserService {
    UserResDTO register(RegisterReqDTO userNew);
    String login(UserLoginReqDTO userLogin);

    UserResDTO getUserById(Long id);

    boolean deleteUser(Long id);

    UserResDTO updateUser(Long id, RegisterReqDTO request);
}
