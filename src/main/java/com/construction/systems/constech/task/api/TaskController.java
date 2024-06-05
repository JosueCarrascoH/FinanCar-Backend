package com.construction.systems.constech.task.api;

import com.construction.systems.constech.shared.exception.InternalServerErrorException;
import com.construction.systems.constech.task.domain.model.entities.Task;
import com.construction.systems.constech.task.domain.service.TaskService;
import com.construction.systems.constech.task.mapping.TaskMapper;
import com.construction.systems.constech.task.resource.CreateTaskResource;
import com.construction.systems.constech.task.resource.TaskResource;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Tag(name = "Tasks", description = "Everything about your Tasks")
@AllArgsConstructor
@RestController
@RequestMapping("tasks")
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = {"Content-Type", "Authorization"},methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE,RequestMethod.PUT})
public class TaskController {
    private final TaskService taskService;

    private final TaskMapper taskMapper;

    @Operation(
            summary = "Add a new task to the constech" ,
            description = "Add a new task to the constech",
            operationId = "addTask",
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
    public ResponseEntity<TaskResource> save(@RequestBody CreateTaskResource assigned) {
        if (taskService.existsByAssigned(assigned.getAssigned())) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "Task with the same assigned already exists.");
        }

        return new ResponseEntity<>(
                taskMapper.toResource(taskService.save(taskMapper.toEntity(assigned))),
                HttpStatus.CREATED);
    }

    @Operation(
            summary = "Get tasks to the constech" ,
            description = "Get tasks to the constech",
            operationId = "getTask",
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
    @GetMapping
    public List<Task> fetchAll() {
        return taskService.fetchAll();
    }

    @Operation(
            summary = "Delete tasks to the constech" ,
            description = "Delete tasks to the constech",
            operationId = "deleteTask",
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
    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteById(@PathVariable("id") Integer id) {
        if (taskService.deleteById(id)) {
            return ResponseEntity.noContent().build();
        }
        throw new InternalServerErrorException("Student", "id", String.valueOf(id), "deleted");
    }

    @Operation(
            summary = "Put tasks to the constech" ,
            description = "Put tasks to the constech",
            operationId = "putTask",
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
    @PutMapping("{id}")
    public ResponseEntity<TaskResource> update(@PathVariable("id") Integer id, @RequestBody Task request) {
        Task updatedTask = taskService.update(id, request);
        return ResponseEntity.ok(taskMapper.toResource(updatedTask));
    }

    @GetMapping("title/{title}")
    public ResponseEntity<List<TaskResource>> fetchTitle(@PathVariable("title") String title){
        List<Task> tasks = taskService.fetchByTitle(title);
        List<TaskResource> taskResources = tasks.stream()
                .map(taskMapper::toResource)
                .collect(Collectors.toList());

        return ResponseEntity.ok(taskResources);
    }


    @GetMapping("assigned/{assigned}")
    public ResponseEntity<Task> fetchAsssigned(@PathVariable("assigned") String assigned){
        return ResponseEntity.ok(taskService.fetchByAssigned(assigned));
    }
}
