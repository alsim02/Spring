package it.eng.corso.TaskService.controller;

import it.eng.corso.TaskService.model.task;
import it.eng.corso.TaskService.service.taskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class taskController {

    /*
    le API richieste:

	•	POST /api/v1/tasks: Crea un nuovo task.

	•	GET /api/v1/tasks: Elenco di tutti i task.

	•	GET /api/v1/tasks/{id}: Dettaglio di un task.

	•	PUT /api/v1/tasks/{id}: Aggiorna i dettagli di un task.

	•	DELETE /api/v1/tasks/{id}: Cancella un task.

	•	GET /api/v1/tasks?completed=true/false: Filtra i task in base allo stato
     */

    @Autowired
    private taskService taskServ;

    //http://localhost:8080/api/v1/tasks?completed=true&nome=EsempioTask
    @PostMapping("/tasks")
    public String createTask(@RequestParam Boolean completed, @RequestParam String nome){

        taskServ.createTask(completed,nome);

        return "Success -controller";

    }

    @GetMapping("/tasks")
    public List<task> getAllTasks(){

        List<task> lista = taskServ.getAllTasks();

        return lista;
    }

    @GetMapping("/tasks/{id}")
    public task getTask(@PathVariable Long id){

        Optional<task> t = taskServ.getTask(id);

        return t.orElse(null);
    }

    @PutMapping("/tasks/{id}")
    public String updateTask(@PathVariable Long id, @RequestParam Optional<String> nome, @RequestParam Optional<Boolean> completed){

        taskServ.updateTask(id,nome,completed);

        return "Success -controller";
    }

    @DeleteMapping("/tasks/{id}")
    public String deleteTask(@PathVariable Long id){

        taskServ.deleteTask(id);

        return "Cancellato -controller";
    }


    //http://localhost:8080/api/v1/tasks2?completed=True
    //se scrivo tasks non funziona, errore di mapping del RequestMapping
    @GetMapping("/tasks2")
    public List<task> findTaskByCompleted(@RequestParam Boolean completed){

        List<task> lista = taskServ.getTaskByCompleted(completed);

        return lista;
    }

}
