package com.example.desafioEstagioJavaBackEnd_EnosRocha.interfaces;

import com.example.desafioEstagioJavaBackEnd_EnosRocha.application.dto.CreateNewTask;
import com.example.desafioEstagioJavaBackEnd_EnosRocha.application.dto.UpdateTask;
import com.example.desafioEstagioJavaBackEnd_EnosRocha.application.services.TaskService;
import com.example.desafioEstagioJavaBackEnd_EnosRocha.domain.entity.Task;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("task")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }


    @PostMapping("/create")
    @Operation(summary = "Create a new task", description = "Create a new task using a @Valid DTO called createNewUser")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Task has been successfully created"),
            @ApiResponse(responseCode = "400", description = "Invalid input for creating task")

    })
    public ResponseEntity<Task> createNewTaskController(
            @Parameter(description = "DTO containing data to create a new task")
            @Valid @RequestBody CreateNewTask createNewTask) {
        Task taskResponse = taskService.createNewTaskService(createNewTask);
        return ResponseEntity.status(HttpStatus.CREATED).body(taskResponse);
    }


    @GetMapping("/get")
    @Operation(summary = "Get all task by filter", description = "Return all tasks that matches to the filters status,priority and deadline parameters")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Tasks returned successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid filter parameters")
    })
    public ResponseEntity<List<Task>> getTasksController(
            @Parameter(description = "Filter tasks by status") @RequestParam(required = false) String status,
            @Parameter(description = "Filter tasks by priority") @RequestParam(required = false) String priority,
            @Parameter(description = "Filter tasks by deadline (format: YYYY-MM-DD)") @RequestParam(required = false) LocalDate deadLine
    ) {
        List<Task> taskLIst = taskService.getTasksService(status, priority, deadLine);
        return ResponseEntity.status(HttpStatus.OK).body(taskLIst);
    }


    @PutMapping("/updatetask/{id}")
    @Operation(summary = "Update task by id", description = "Update a specific task through the given id the url(as a pathvariable)")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Task has been updated"),
            @ApiResponse(responseCode = "400", description = "Invalid DTO for update"),
            @ApiResponse(responseCode = "404", description = "Task for update has been found")
    })
    public ResponseEntity<Task> updateTaskController(
            @Parameter(description = "ID of the task to update") @PathVariable(value = "id") Long id,
            @Parameter(description = "DTO containing data to update the task") @RequestBody UpdateTask updateTask) {
        Task taskResponse = taskService.updateTask(id, updateTask);
        return ResponseEntity.status(HttpStatus.OK).body(taskResponse);

    }

    @DeleteMapping("/deletetask")
    @Operation(summary = "Delete task by id or name", description = "Delete a specific task through the given id or name")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Task has been deleted"),
            @ApiResponse(responseCode = "400", description = "Task cant be deleted"),
            @ApiResponse(responseCode = "404", description = "Requested Task has not been found")
    })
    public ResponseEntity deleteTaskController(
            @Parameter(description = "ID of the task to delete") @RequestParam(required = false) Long id,
            @Parameter(description = "Name of the task to delete") @RequestParam(required = false) String name
    ) {
        boolean response = taskService.deleteTaskByIdOrName(id, name);
        return response == true ? ResponseEntity.status(HttpStatus.OK).build() : ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

}
