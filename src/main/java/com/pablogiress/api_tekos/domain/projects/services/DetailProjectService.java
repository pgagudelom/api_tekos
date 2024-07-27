package com.pablogiress.api_tekos.domain.projects.services;

import com.pablogiress.api_tekos.domain.projects.DataListProject;
import com.pablogiress.api_tekos.domain.projects.Project;
import com.pablogiress.api_tekos.domain.projects.ProjectRepository;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DetailProjectService {

    /*
 ------------------------------------------------------------------------
 * DEPENDENCIES INJECT
 * ---------------------------------------------------------------------*/
    @Autowired
    ProjectRepository projectRepository;
    /*--------------------------------------------------------------------*/


    //VIEW DETAIL ABOUT A PROJECT
    public DataListProject viewProject(Long id){

        if(id == null){
            throw new ValidationException("Invalid ID");
        }

        var projectExists = projectRepository.existsById(id);

        if(!projectExists){
            throw new ValidationException("ID doesn't exists");
        }

        Project project =projectRepository.getReferenceById(id);

        return new DataListProject(project.getId(), project.getName(), project.getDescription(),
                project.getStatus(), project.getStartDate(), project.getEndDate(), project.getCreatedAt(),
                project.getUpdatedAt());
    }
}
