package com.pablogiress.api_tekos.domain.projects;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Table(name = "projects")
@Entity(name = "Project")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private String status;
    private LocalDateTime startDate;
    private LocalDateTime endDate;


    public Project(DataNewProject data) {
    }
}
