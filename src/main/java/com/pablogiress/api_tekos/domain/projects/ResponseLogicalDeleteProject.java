package com.pablogiress.api_tekos.domain.projects;

public record ResponseLogicalDeleteProject(
        Long id,
        String respuesta
) {
    public ResponseLogicalDeleteProject(Project project) {

        this(project.getId(), "Project send to trash");
    }
}
