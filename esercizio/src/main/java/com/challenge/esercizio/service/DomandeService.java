package com.challenge.esercizio.service;

import com.challenge.esercizio.model.Domande;
import com.challenge.esercizio.repository.DomandeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DomandeService {

    @Autowired
    private DomandeRepository domandeRepository;

    private ArrayList<Domande> listaDomande;

    //create
    public ResponseEntity<String> insert(Domande d) {

        System.out.println("Descrizione ricevuta: " + d.getDescrizione());

        // Salvataggio della domanda nel repository
        domandeRepository.save(d);

        // Restituzione della risposta
        return ResponseEntity.ok("Inserimento Riuscito");
    }

    //read
    public Optional<Domande> read(Long id){

        return domandeRepository.findById(id);
    }

    //readAll
    public ArrayList<Domande> read(){

        listaDomande = (ArrayList<Domande>) domandeRepository.findAll();

        return listaDomande;
    }

    //update
    public ResponseEntity<String> update(Domande d){

        domandeRepository.save(d);

        // Restituzione della risposta
        return ResponseEntity.ok("Aggiornamento Riuscito");
    }

    //delete
    public ResponseEntity<String> delete(Long id) {
        Optional<Domande> domanda = domandeRepository.findById(id);

        if (domanda.isPresent()) {
            // Se la domanda esiste, la eliminiamo
            domandeRepository.deleteById(id);
            // Restituisci 200 OK con un messaggio
            return ResponseEntity.ok("Domanda eliminata con successo.");
        } else {
            // Se la domanda non esiste, restituiamo un errore 404
            return ResponseEntity.notFound().build();
        }
    }



}
