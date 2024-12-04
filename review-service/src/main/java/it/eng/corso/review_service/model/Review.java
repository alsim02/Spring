package it.eng.corso.review_service.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Builder //serve per implementare il pattern DTO (Data Transfer Object)
@NoArgsConstructor //serve per Hibernate in quanto userà sempre il costruttore vuoto
@AllArgsConstructor //per completezza aggiungo anche il costruttore con tutti gli args
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String uuid; //servirà per il DTO
    private String uuidBook; //reference all'uuid dell'entità book a cui la review si riferisce (Foreign Key)
    private Double stars;

    @CreationTimestamp
    private LocalDateTime createdAt;

}
