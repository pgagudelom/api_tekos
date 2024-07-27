package com.pablogiress.api_tekos.domain.tasks;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Table(name = "tasks")
@Entity(name = "Task")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String name;
    String details;
    String status;
    LocalDateTime expire;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;
}
