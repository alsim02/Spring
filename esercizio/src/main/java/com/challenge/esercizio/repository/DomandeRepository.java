package com.challenge.esercizio.repository;

import com.challenge.esercizio.model.Domande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DomandeRepository extends JpaRepository<Domande,Long> {
}
