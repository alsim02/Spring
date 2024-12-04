package it.eng.corso.chatservice.controller;

import it.eng.corso.chatservice.model.Message;
import it.eng.corso.chatservice.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Flux;

import java.awt.*;
import java.time.LocalDateTime;

@RestController
public class ChatController {

    @Autowired
    private MessageService messageService;

    @PostMapping("/chat")
    public Mono<Message> save(@RequestBody Message message){

        message.setCreatedAt(LocalDateTime.now());
        return messageService.save(message);
    }

    //, produces = MediaType = TEXT_EVENT_STREAM_VALUE
    @GetMapping("/chat/room/{roomId}")
    public Flux<Message> findByRoomId(@PathVariable Integer roomId){
        return messageService.findByRoomId(roomId);
    }

}
