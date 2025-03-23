package com.example.spring.jpastart01.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@ToString
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "member")
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String username;
    private int age;
}
