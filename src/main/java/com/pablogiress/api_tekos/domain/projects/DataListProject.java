package com.pablogiress.api_tekos.domain.projects;

import java.time.LocalDateTime;

public record DataListProject(
        Long id,
        String name,
        String description,
        String status,
        LocalDateTime startDate,
        LocalDateTime endDate,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {

    public DataListProject(Project project){
        this(project.getId(), project.getName(), project.getDescription(), project.getStatus(), project.getStartDate(), project.getEndDate(),
                project.getCreatedAt(), project.getUpdatedAt());
    }

}
