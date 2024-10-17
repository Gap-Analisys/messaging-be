package com.d2y.messaging_app.services;

import com.d2y.messaging_app.dto.MessageResponse;
import com.d2y.messaging_app.entities.Message;
import com.d2y.messaging_app.repositories.MessageRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MessageService {

    private final MessageRepository messageRepository;

    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public Message saveMessage(String content) {
        Message message = new Message();
        message.setContent(content);
        return messageRepository.save(message);
    }
}

