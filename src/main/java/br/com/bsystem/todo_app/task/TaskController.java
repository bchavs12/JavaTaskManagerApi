package br.com.bsystem.todo_app.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.config.Task;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private ITaskRepository taskRepository;

    @Autowired
    public TaskController(ITaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @GetMapping("/")
    public ResponseEntity<List<TaskModel>> getAllTasks() {
        List<TaskModel> tasks = taskRepository.findAll();


        return ResponseEntity.status(HttpStatus.OK).body(tasks);
    }

    @PostMapping("/")
    public ResponseEntity<TaskModel> addTask(@RequestBody TaskModel newTask) {
        TaskModel taskCreated = taskRepository.save(newTask);


        return ResponseEntity.status(HttpStatus.CREATED).body(taskCreated);
    }

}