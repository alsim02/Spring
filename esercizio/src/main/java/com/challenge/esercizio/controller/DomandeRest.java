package com.challenge.esercizio.controller;

import com.challenge.esercizio.model.Domande;
import com.challenge.esercizio.service.DomandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/domande")
public class DomandeRest {

    @Autowired
    private DomandeService domandeService;

    @PostMapping
    public ResponseEntity<String> inserisciDomanda(@RequestBody Domande d){

        return domandeService.insert(d);
    }

    @GetMapping("/{id}")
    public Optional<Domande> getDomanda(@PathVariable("id") Long id){
        return  domandeService.read(id);
    }

    @GetMapping
    public ArrayList<Domande> getAllDomande(){
        return  domandeService.read();
    }

    @PutMapping
    public ResponseEntity<String> update(@RequestBody Domande d){
        return domandeService.update(d);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable("id") Long id){
        return domandeService.delete(id);
    }


}
