package it.eng.corso.TaskService.handler;

import it.eng.corso.TaskService.exception.NoDataFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;

//è un controllore, una sorta di observer, in costante ascolto
@ControllerAdvice
public class TaskExceptionHandler {

    //osserva se viene invocata un eccezione di questo tipo: NoDataFoundException
    @ExceptionHandler(NoDataFoundException.class)
    public ResponseEntity<Object> noDataFoundException(NoDataFoundException e){
        HashMap<String,Object> body = new HashMap<>();

        body.put("timestamp", LocalDateTime.now());
        body.put("ERROR_CODE","1000");
        body.put("message","non ho trovato l'id richiesto");

        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }

}
