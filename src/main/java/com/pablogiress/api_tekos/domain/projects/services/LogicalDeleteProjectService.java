package com.pablogiress.api_tekos.domain.projects.services;

import com.pablogiress.api_tekos.domain.projects.DataDeleteProject;
import com.pablogiress.api_tekos.domain.projects.Project;
import com.pablogiress.api_tekos.domain.projects.ResponseLogicalDeleteProject;
import com.pablogiress.api_tekos.domain.projects.ProjectRepository;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LogicalDeleteProjectService {

    @Autowired
    ProjectRepository projectRepository;

    public ResponseLogicalDeleteProject deleteProject(Long id){
        Project project =projectRepository.getReferenceById(id);

        var projectExists = projectRepository.existsById(id);

        if(!projectExists){
            throw new ValidationException("Project not exists");
        }

        project.setStatus("inactive");

        projectRepository.save(project);

        return new ResponseLogicalDeleteProject(project);
    }

}
