package com.example.SpringHomeWork5.services;

import com.example.SpringHomeWork5.model.Task;
import com.example.SpringHomeWork5.model.Status;
import com.example.SpringHomeWork5.repositories.TaskRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

/**
 * Класс для передачи запросов в репозиторий
 */
@Service
@AllArgsConstructor
public class TaskService {

    private final TaskRepository repository;

    /**
     * Метод получения списка всех задач
     */
    public List<Task> getAllTasks(){
        return repository.findAll();
    }

    /**
     * Метод сохранения задачи
     */
    public Task saveTask(Task task){
        return repository.save(task);
    }

    /**
     * Метод добавления задачи
     */
    public Task createTask(String title){
        Task crTask = new Task();
        crTask.setTitle(title);
        crTask.setStatus(Status.NOT_STARTED);
        crTask.setDateCreate(LocalDateTime.now());
        return saveTask(crTask);
    }

    /**
     * Метод удаления задачи по id
     */
    public void deleteTask(Long id){
        repository.deleteById(id);
    }

    /**
     * Метод поиска списка задач по статусу
     */
    public List<Task> findByStatus(Status status){
        return repository.findByStatus(status);
    }

    /**
     * Метод автоматического изменения статуса задач при каждом запросе
     */
    public Task updateTaskStatus(Long id){
        Optional<Task> optionalTask = repository.findById(id);
        if (optionalTask.isPresent()) {
            Task task = optionalTask.get();
            if (task.getStatus().equals(Status.NOT_STARTED)){
                task.setStatus(Status.IN_PROGRESS);
            } else if (task.getStatus().equals(Status.IN_PROGRESS)){
                task.setStatus(Status.COMPLETED);
            }
            return repository.save(task);
        } else {
            throw new IllegalArgumentException("Задача с идентификатором " + id + "не найдена");
        }
    }
}
