package com.dadry.universityproject.entity;

import com.dadry.universityproject.entity.enums.Degree;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
public class Lector {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Double salary;

    @Enumerated(EnumType.STRING)
    private Degree degree;

    @ManyToMany(mappedBy = "lectors")
    private Set<Department> departments = new HashSet<>();

}
