package com.challenge.esercizio.controller;

import com.challenge.esercizio.model.Risposte;
import com.challenge.esercizio.service.RisposteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/risposte")
public class RisposteRest {
    
    @Autowired
    private RisposteService risposteService;

    @PostMapping
    public ResponseEntity<String> inserisciRisposta(@RequestBody Risposte r){

        return risposteService.insert(r);
    }

    @GetMapping("/{id}")
    public Optional<Risposte> getRisposta(@PathVariable("id") Long id){
        return  risposteService.read(id);
    }

    @GetMapping
    public ArrayList<Risposte> getAllRisposte(){
        return  risposteService.read();
    }

    @PutMapping
    public ResponseEntity<String> update(@RequestBody Risposte d){
        return risposteService.update(d);
    }
}
