CREATE TABLE projects_tasks(
 id BIGINT NOT NULL AUTO_INCREMENT,
 project_id BIGINT,
 task_id BIGINT,

CONSTRAINT fk_projects_project_id FOREIGN KEY(project_id) REFERENCES projects(id),
CONSTRAINT fk_projects_task_id FOREIGN KEY(task_id) REFERENCES tasks(id),
 PRIMARY KEY(id)
);