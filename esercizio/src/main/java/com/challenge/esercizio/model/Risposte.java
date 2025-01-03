package com.challenge.esercizio.model;

import jakarta.persistence.*;


@Entity
public class Risposte {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descrizione;
    private String corretta;

    @ManyToOne
    @JoinColumn(name = "domanda_id")
    private Domande domanda_id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public String getCorretta() {
        return corretta;
    }

    public void setCorretta(String corretta) {
        this.corretta = corretta;
    }

    public Domande getDomanda_id() {
        return domanda_id;
    }

    public void setDomanda_id(Domande domanda_id) {
        this.domanda_id = domanda_id;
    }
}
