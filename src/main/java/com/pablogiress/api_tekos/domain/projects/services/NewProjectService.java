package com.pablogiress.api_tekos.domain.projects.services;

import com.pablogiress.api_tekos.domain.projects.DataNewProject;
import com.pablogiress.api_tekos.domain.projects.DataResponseProject;
import com.pablogiress.api_tekos.domain.projects.Project;
import com.pablogiress.api_tekos.domain.projects.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class NewProjectService {

    /*
    ------------------------------------------------------------------------
    * DEPENDENCIES INJECT
    * ---------------------------------------------------------------------*/
    @Autowired
    ProjectRepository projectRepository;
    /*--------------------------------------------------------------------*/


    /*----------------------------------------------------------------------
    * --REGISTER NEW PROJECT
    * ----------------------------------------------------------------------
    * */
    public DataResponseProject newProject(DataNewProject data){

        var status = "active";

        var project = new Project();
        project.setName(data.name());
        project.setDescription(data.description());
        project.setStatus(status);
        project.setStartDate(data.startDate());
        project.setEndDate(data.endDate());

        projectRepository.save(project);

        return new DataResponseProject(project);

    }
}
