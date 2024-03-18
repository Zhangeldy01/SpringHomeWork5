package com.example.SpringHomeWork5.repositories;

import com.example.SpringHomeWork5.model.Status;
import com.example.SpringHomeWork5.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Класс для работы с БД
 */
@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    public List<Task> findByStatus(Status status);
}
