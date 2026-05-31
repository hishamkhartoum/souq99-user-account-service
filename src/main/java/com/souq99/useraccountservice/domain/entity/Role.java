package com.souq99.useraccountservice.domain.entity;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.SoftDelete;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "roles")
@SoftDelete
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
}
