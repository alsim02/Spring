package com.challenge.esercizio.service;


import com.challenge.esercizio.model.Risposte;
import com.challenge.esercizio.repository.RisposteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class RisposteService {

    @Autowired
    private RisposteRepository risposteRepository;

    private ArrayList<Risposte> listaRisposte;

    //create
    public ResponseEntity<String> insert(Risposte r) {

        // Salvataggio della domanda nel repository
        risposteRepository.save(r);

        // Restituzione della risposta
        return ResponseEntity.ok("Inserimento Riuscito");
    }

    //read
    public Optional<Risposte> read(Long id){

        return risposteRepository.findById(id);
    }

    //readAll
    public ArrayList<Risposte> read(){

        listaRisposte = (ArrayList<Risposte>) risposteRepository.findAll();

        return listaRisposte;
    }

    //update
    public ResponseEntity<String> update(Risposte d){

        risposteRepository.save(d);

        // Restituzione della risposta
        return ResponseEntity.ok("Aggiornamento Riuscito");
    }

    //delete
    public ResponseEntity<String> delete(Long id) {
        Optional<Risposte> domanda = risposteRepository.findById(id);

        if (domanda.isPresent()) {
            // Se la domanda esiste, la eliminiamo
            risposteRepository.deleteById(id);
            // Restituisci 200 OK con un messaggio
            return ResponseEntity.ok("Domanda eliminata con successo.");
        } else {
            // Se la domanda non esiste, restituiamo un errore 404
            return ResponseEntity.notFound().build();
        }
    }
}
