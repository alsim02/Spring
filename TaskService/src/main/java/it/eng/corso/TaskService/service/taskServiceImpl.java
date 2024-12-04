package it.eng.corso.TaskService.service;

import it.eng.corso.TaskService.exception.NoDataFoundException;
import it.eng.corso.TaskService.model.task;
import it.eng.corso.TaskService.repository.taskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class taskServiceImpl implements taskService{

    @Autowired
    private taskRepository taskRep;

    @Override
    public String createTask(Boolean completed, String nome) {

        task t = new task();
        t.setCompleted(completed);
        t.setNome(nome);

        taskRep.save(t);

       return "Success";
    }

    @Override
    public List<task> getAllTasks(){

       return taskRep.findAll();
    }

    @Override
    public Optional<task> getTask(Long id){

        //qui ho un eccezzione personalizzata
        return Optional.of(taskRep.findById(id).orElseThrow(NoDataFoundException::new));
    }

    @Override
    public String updateTask(Long id, Optional<String> nome, Optional<Boolean> completed) {

        // Recupera il task esistente dal repository
        Optional<task> existingTask = taskRep.findById(id);

        if (existingTask.isPresent()) {
            task t = existingTask.get();  // Ottieni il task esistente

            // Controlla se 'nome' è presente e non vuoto, altrimenti lascia il valore esistente
            nome.ifPresent(n -> {
                if (!n.trim().isEmpty()) {
                    t.setNome(n);  // Imposta 'nome' se è presente e non vuoto
                }
            });

            // Controlla se 'completed' è presente, altrimenti lascia il valore esistente
            completed.ifPresent(c -> t.setCompleted(c));

            // Salva l'oggetto aggiornato
            taskRep.save(t);

            return "Task aggiornato con successo";
        } else {
            return "Task non trovato";
        }

        /*
        VERSIONE SENZA JAVA StreamAPI E LAMBDA FUNCTION

        Optional<task> existingTask = taskRep.findById(id);

        if (existingTask.isPresent()) {

            task t = existingTask.get();


            if (nome.isPresent()) {
                String nomeValue = nome.get();

                if (!nomeValue.trim().isEmpty()) {
                    t.setNome(nomeValue);
                }
            }


            if (completed.isPresent()) {
                t.setCompleted(completed.get());
            }

            taskRep.save(t);

            return "Task aggiornato con successo";
        } else {
            return "Task non trovato";
        }
        */

    }

    @Override
    public String deleteTask(Long id) {

        taskRep.deleteById(id);

        return "Cancellato -service";
    }

    @Override
    public List<task> getTaskByCompleted(Boolean completed){

        List<task> lista = taskRep.findAllByCompleted(completed);

        return lista;

    }


}
