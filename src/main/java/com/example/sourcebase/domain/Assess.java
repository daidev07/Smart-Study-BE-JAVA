package com.example.sourcebase.domain;

import com.example.sourcebase.domain.enumeration.ETypeSubmit;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Entity
@Table(name = "assesses")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Assess {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne
    User user;

    @ManyToOne
    User toUser;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    LocalDate assessmentDate;

    @Enumerated(EnumType.STRING)
    ETypeSubmit assessmentType;

    int totalPoint;
}
