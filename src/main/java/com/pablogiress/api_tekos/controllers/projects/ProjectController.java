package com.pablogiress.api_tekos.controllers.projects;

import com.pablogiress.api_tekos.domain.projects.*;
import com.pablogiress.api_tekos.domain.projects.services.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @Autowired
    ListProjectService listProjectService;

    @Autowired
    DetailProjectService detailProjectService;

    @Autowired
    UpdateProjectService updateProjectService;

    @Autowired
    LogicalDeleteProjectService logicalDeleteProjectService;

    //----------------------------------------------------------------


    //Method to register new projects
    @PostMapping
    public ResponseEntity<DataResponseProject> newProject(@RequestBody @Valid DataNewProject data){
        var response = newProjectService.newProject(data);

        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<Page<DataListProject>> listProject(Pageable pageable){
        var response = listProjectService.listProjects(pageable);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DataListProject> detailProject(@PathVariable Long id){
        var response = detailProjectService.viewProject(id);

        return ResponseEntity.ok(response);
    }

    @PutMapping
    @Transactional
    public ResponseEntity<DataResponseProject> updateProject(@RequestBody @Valid DataUpdateProject data){
        var project = updateProjectService.updateProject(data);

        return ResponseEntity.ok(project);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<ResponseLogicalDeleteProject> deleteProject(@PathVariable Long id){
        var project = logicalDeleteProjectService.deleteProject(id);

        return ResponseEntity.ok(project);
    }

}
