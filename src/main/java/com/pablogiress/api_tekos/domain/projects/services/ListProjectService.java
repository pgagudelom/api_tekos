package com.pablogiress.api_tekos.domain.projects.services;

import com.pablogiress.api_tekos.domain.projects.DataListProject;
import com.pablogiress.api_tekos.domain.projects.ProjectRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ListProjectService {

    @Autowired
    ProjectRepository projectRepository;

    @Transactional
    public Page<DataListProject> listProjects(Pageable pagination){
        return projectRepository.findByStatusActive(pagination).map(DataListProject::new);

    }
}
