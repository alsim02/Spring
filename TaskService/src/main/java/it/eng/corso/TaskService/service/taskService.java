package it.eng.corso.TaskService.service;

import it.eng.corso.TaskService.model.task;

import java.util.List;
import java.util.Optional;

public interface taskService {

    public String createTask(Boolean completed, String nome);

    public List<task> getAllTasks();

    public Optional<task> getTask(Long id);

    public String updateTask(Long id, Optional<String> nome, Optional<Boolean> completed);

    public String deleteTask(Long id);

    public List<task> getTaskByCompleted(Boolean completed);
}
