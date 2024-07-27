package com.pablogiress.api_tekos.domain.projects.services;

import com.pablogiress.api_tekos.domain.projects.DataResponseProject;
import com.pablogiress.api_tekos.domain.projects.DataUpdateProject;
import com.pablogiress.api_tekos.domain.projects.Project;
import com.pablogiress.api_tekos.domain.projects.ProjectRepository;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateProjectService {

    @Autowired
    ProjectRepository projectRepository;

    public DataResponseProject updateProject(DataUpdateProject data){
        Project project = projectRepository.getReferenceById(data.getId());
        var projectExists = projectRepository.existsById(data.getId());
        if(!projectExists){
            throw new ValidationException("Project doesn't exists");
        }

        project.setName(data.getName());
        project.setDescription(data.getDescription());
        project.setStatus(data.getStatus());
        project.setStartDate(data.getStartDate());
        project.setEndDate(data.getEndDate());

        projectRepository.save(project);
        return new DataResponseProject(project);
    }
}
