package it.eng.corso.chatservice.service;

import it.eng.corso.chatservice.model.Message;
import it.eng.corso.chatservice.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class MessageServiceImpl implements MessageService{

    @Autowired
    private MessageRepository messageRepository;


    @Override
    public Flux<Message> findByRoomId(Integer roomId) {
        return messageRepository.findByRoomId(roomId);
    }

    @Override
    public Mono<Message> save(Message message) {
        return messageRepository.save(message); //restituisce un Mono con l'entità che stiamo salvando.
    }
}
