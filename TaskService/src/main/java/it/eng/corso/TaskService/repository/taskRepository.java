package it.eng.corso.TaskService.repository;

import it.eng.corso.TaskService.model.task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface taskRepository extends JpaRepository<task, Long> {

    @Query(value = "SELECT * FROM task WHERE completed = ?1 ", nativeQuery = true)
    List<task> findAllByCompleted(Boolean completed);
}
