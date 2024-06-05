package com.construction.systems.constech.customer.api;


import com.construction.systems.constech.customer.domain.model.entities.Project;
import com.construction.systems.constech.customer.domain.service.ProjectService;
import com.construction.systems.constech.shared.exception.InternalServerErrorException;
import com.construction.systems.constech.task.resource.TaskResource;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Tag(name = "Banks", description = "Everything about your projects")
@AllArgsConstructor
@RestController

@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = {"Content-Type", "Authorization"},methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE,RequestMethod.PUT})
@RequestMapping("/banks")
public class ProjectController {


    private final ProjectService projectService;


    @Operation(
            summary = "Add a new project to the constech" ,
            description = "Add a new project to the constech",
            operationId = "addproject",
            responses = {
                    @ApiResponse(
                            responseCode = "201",
                            description = "Successful operation",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = TaskResource.class)
                            )
                    ),
                    @ApiResponse (
                            responseCode = "400",
                            description = "Bad Request",
                            content = @Content (
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = RuntimeException.class)
                            )
                    )
            }
    )

    @PostMapping
    public Project save(@RequestBody Project project) {
        return projectService.save(project);
    }

    @GetMapping
    public List<Project> fetchAll() {
        return projectService.fetchAll();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteById(@PathVariable("id") Integer id) {
        if (projectService.deleteById(id)) {
            return ResponseEntity.noContent().build();
        }
        throw new InternalServerErrorException("Project", "id", String.valueOf(id), "deleted");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Project> updateProject(@PathVariable Integer id, @RequestBody Project updatedProject) {
        // Verificar si el proyecto con el ID proporcionado existe
        Project existingProject = projectService.getProjectById(id);

        if (existingProject == null) {
            return ResponseEntity.notFound().build();
        }

        // Actualizar el proyecto
        BeanUtils.copyProperties(updatedProject, existingProject, "id");
        Project savedProject = projectService.updateProject(id, existingProject);

        return ResponseEntity.ok(savedProject);
    }

    @GetMapping("/bystatus/{status}")
    public ResponseEntity<List<Project>> getProjectsByStatus(@PathVariable String status) {
        List<Project> projects = projectService.getProjectsByStatus(status);
        return ResponseEntity.ok(projects);
    }
}
