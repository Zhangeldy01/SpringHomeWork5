package com.example.SpringHomeWork5.controllers;

import com.example.SpringHomeWork5.model.Task;
import com.example.SpringHomeWork5.model.Status;
import com.example.SpringHomeWork5.services.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Класс для обработки запросов
 */
@RestController
@RequestMapping("/tasks")
@AllArgsConstructor
public class TaskController {

    private final TaskService taskService;

    /**
     * Метод обработки Get-запроса (пустой)
     * @return список всех задач
     */
    @GetMapping()
    public List<Task> getAllTask(){
        return taskService.getAllTasks();
    }

    /**
     * Метод обработки запроса на добавление задачи
     * @param title тело задачи, передается по параметрам через body
     * @return новая задача
     */
    @PostMapping()
    public Task addTaskFromParam(@RequestParam("title") String title){
        return taskService.createTask(title);
    }

    /** Метод обработки запроса списка задач с указанным статусом
     * (NOT_STARTED, IN_PROGRESS, COMPLETED)
     * @param status текущий статус
     * @return список задач
     */
    @GetMapping("/status/{status}")
    public List<Task> getTaskByStatus(@PathVariable Status status){
        return taskService.findByStatus(status);
    }

    /**
     * Метод обработки запроса изменения статуса задачи по id
     * @param id ID задачи
     * @return задача с измененным статусом
     */
    @PutMapping("/{id}")
    public Task updateTaskStatus(@PathVariable Long id){
        return taskService.updateTaskStatus(id);
    }

    /**
     * Метод обработки запроса на удаления задачи по ее id
     * @param id ID задачи
     */
    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id){
        taskService.deleteTask(id);
    }
}
