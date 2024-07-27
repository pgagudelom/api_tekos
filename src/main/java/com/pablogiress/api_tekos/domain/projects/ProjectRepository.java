package com.pablogiress.api_tekos.domain.projects;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProjectRepository extends JpaRepository<Project, Long> {

    @Query("""
            SELECT a FROM Project a ORDER BY createdAt DESC
            """)
    Page<Project> findAllProjects(Pageable pagination);
}
