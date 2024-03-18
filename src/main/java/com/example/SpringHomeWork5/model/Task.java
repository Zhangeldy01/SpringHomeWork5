package com.example.SpringHomeWork5.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * Класс задача
 */
@Data
@Entity
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String title;


    @Enumerated(EnumType.STRING)
    private Status status;

//    @Column(nullable = false)
//    private String description;

    private LocalDateTime dateCreate;
}
