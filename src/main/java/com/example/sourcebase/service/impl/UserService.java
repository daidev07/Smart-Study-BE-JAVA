package com.example.sourcebase.service.impl;

import com.example.sourcebase.domain.Role;
import com.example.sourcebase.domain.User;
import com.example.sourcebase.domain.UserRole;
import com.example.sourcebase.domain.dto.reqdto.user.RegisterReqDTO;
import com.example.sourcebase.domain.dto.reqdto.user.UserLoginReqDTO;
import com.example.sourcebase.domain.dto.resdto.user.UserResDTO;
import com.example.sourcebase.mapper.UserMapper;
import com.example.sourcebase.repository.IRoleRepository;
import com.example.sourcebase.repository.IUserRepository;
import com.example.sourcebase.repository.IUserRoleRepository;
import com.example.sourcebase.service.IUserService;
import com.example.sourcebase.util.ErrorCode;

import com.example.sourcebase.util.*;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import com.example.sourcebase.exception.AppException;

@Service
@AllArgsConstructor
@FieldDefaults(level = lombok.AccessLevel.PRIVATE, makeFinal = true)
public class UserService implements IUserService {
    Log log = new Log();
    IUserRepository userRepository;
    IRoleRepository roleRepository;
    IUserRoleRepository userRoleRepository;
    UserMapper userMapper = UserMapper.INSTANCE;

    @Override
    public UserResDTO register(RegisterReqDTO registerReqDTO) {
        if (userRepository.existsUserByEmailIgnoreCaseOrUsernameIgnoreCaseOrPhoneNumber(
                registerReqDTO.getEmail(),
                registerReqDTO.getUsername(),
                registerReqDTO.getPhoneNumber())) {
            log.LogError(ErrorCode.USERNAME_EXISTS);
            throw new IllegalArgumentException("User with given email, username, or phone number already exists.");
        }
        User userNew = userMapper.toUser(registerReqDTO);
//        saveUserRole(userNew, roleRepository.findById(1L).orElseThrow(() -> new NoSuchElementException("Role not found")));
        User createdUser = userRepository.save(userNew);
        UserResDTO resultUserResDTO = userMapper.toUserResDTO(createdUser);
        log.LogInfo(SuccessCode.CREATED);

        return resultUserResDTO;
    }

    @Override
    public String login(UserLoginReqDTO userLogin) {
        return null;
    }

    @Override
    public UserResDTO getUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.USER_NOT_FOUND));
        return userMapper.toUserResDTO(user);
    }

    @Override
    public boolean deleteUser(Long id) {
        try {
            User user = userRepository.findById(id)
                    .orElseThrow(() -> new AppException(ErrorCode.USER_NOT_FOUND));
            user.setDeleted(true);
            userRepository.save(user);
            return true;
        }catch (Exception e){
            System.out.println(e);
        }
        return false;
    }

    @Override
    public UserResDTO updateUser(Long id, RegisterReqDTO request) {
        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.USER_NOT_FOUND));
        User userToUpdate = userMapper.toUser(request);
        userToUpdate.setId(id);
//        userToUpdate.setCreatedBy(existingUser.getCreatedBy());
        User updatedUser = userRepository.save(userToUpdate);
        return userMapper.toUserResDTO(updatedUser);
    }
    @Transactional
    public void saveUserRole(User user, Role role) {
        UserRole userRole = new UserRole(user, role);
        userRoleRepository.save(userRole);
    }
}
