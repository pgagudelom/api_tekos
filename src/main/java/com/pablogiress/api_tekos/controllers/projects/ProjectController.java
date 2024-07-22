package com.pablogiress.api_tekos.controllers.projects;

import com.pablogiress.api_tekos.domain.projects.DataNewProject;
import com.pablogiress.api_tekos.domain.projects.DataResponseProject;
import com.pablogiress.api_tekos.domain.projects.services.NewProjectService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/projects")
public class ProjectController {

    /*
    * ---------------------------------------------------------------
    * DEPENDENCIES INJECT
    * ---------------------------------------------------------------
    * */
    @Autowired
    NewProjectService newProjectService;

    //----------------------------------------------------------------


    //Method to register new projects
    @PostMapping
    public ResponseEntity<DataResponseProject> newProject(@RequestBody @Valid DataNewProject data){
        var response = newProjectService.newProject(data);

        return ResponseEntity.ok(response);
    }

}
