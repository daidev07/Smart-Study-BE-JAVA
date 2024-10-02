package com.example.sourcebase.domain;

import com.example.sourcebase.domain.enumeration.EGender;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
@Builder
public class User extends BaseEntity {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    Long id;
    String name;
    String email;
    String phoneNumber;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    LocalDate dob;
    @Enumerated(EnumType.STRING)
    EGender gender;
    String username;
    String password;
    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
    List<UserRole> userRoles;
    boolean isActive;
    boolean isDeleted;
    @OneToMany(mappedBy = "user" , cascade = CascadeType.REMOVE)
    List<UserProject> userProjects;
    @ManyToOne
    Rank rank;
}
