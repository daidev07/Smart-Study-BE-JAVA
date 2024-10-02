package com.example.sourcebase.repository;

import com.example.sourcebase.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;
import java.util.UUID;

public interface IUserRepository extends JpaRepository<User, Long> {
//    @Query("SELECT u FROM User u WHERE u.typeUser = :type AND u.fullName LIKE %:name%")
//    Page<User> findAllUserWithSearch(Pageable pageable, @Param("name") String name, @Param("type") ETypeUser type);
//    boolean existsUsersByEmailIgnoreCaseOrPhoneOrUsernameIgnoreCase(String email, String phone, String username);
    boolean existsUserByEmailIgnoreCaseOrUsernameIgnoreCaseOrPhoneNumber(String email, String username, String phoneNumber);

}
