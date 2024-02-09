package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.model.Messagerie;
import com.example.demo.repository.MessageRepository;

@Service
public class MessageService {
    private final MessageRepository messageRep;
    @Autowired
    public MessageService(MessageRepository userRep) {
        this.messageRep = userRep;
    }

    public ResponseEntity<List<Messagerie>> getAllMessage() {
        return new ResponseEntity<>(messageRep.findAll(),HttpStatus.OK);
    }

    public ResponseEntity<List<Messagerie>> getAllMessageUser(int id) {
        return new ResponseEntity<>(messageRep.findMessageUser(id),HttpStatus.OK);
    }

    public  ResponseEntity<Messagerie> getMessageById(int id) {
        return new ResponseEntity<>(messageRep.findById(id).orElse(null), HttpStatus.OK);
    }

    public ResponseEntity<Messagerie> saveMessage(Messagerie msg) {
        return new ResponseEntity<>(messageRep.save(msg),HttpStatus.OK);
    }
    
}
