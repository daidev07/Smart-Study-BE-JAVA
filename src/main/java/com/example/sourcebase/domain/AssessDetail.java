package com.example.sourcebase.domain;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "assess_details")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AssessDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne
    Assess assess;

    @ManyToOne
    Criteria criteria;

    @ManyToOne
    Question question;

    int value;

    String description;

    boolean isComment;
}
