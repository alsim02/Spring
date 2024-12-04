package it.eng.corso.chatservice.repository;

import it.eng.corso.chatservice.model.Message;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.mongodb.repository.Tailable;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface MessageRepository extends ReactiveMongoRepository<Message,String> {

    @Tailable
    Flux<Message> findByRoomId(Integer roomId); //restituisco un flusso reattivo, dinamico. Questo flusso rimane attivo grazie a Tailable di MongoDB.
    //ottengo un Document di tipo Message.

}
