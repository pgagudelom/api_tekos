package com.pablogiress.api_tekos.domain.projects;

import java.time.LocalDateTime;

public record DataResponseProject(
        Long id,
        String name,
        String status,
        LocalDateTime startDate
) {

    //Constructor
    public DataResponseProject(Project project) {
        this(project.getId(), project.getName(), project.getStatus(), project.getStartDate());
    }
}
