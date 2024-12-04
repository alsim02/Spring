package it.eng.corso.chatservice.service;

import it.eng.corso.chatservice.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface MessageService {

    Flux<Message> findByRoomId(Integer roomId);

    Mono<Message> save(Message message); //quando si salva un messaggio riceverò al più 1 oggetto di tipo Message.


}
