package com.d2y.messaging_app.kafka;

import com.d2y.messaging_app.services.MessageService;
import com.d2y.messaging_app.configs.WebSocketMessageHandler;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import java.io.IOException;

@Service
@RequiredArgsConstructor
@Slf4j
public class KafkaConsumerService {

    private final MessageService messageService;

    @KafkaListener(topics = "message-topic", groupId = "messaging")
    public void listen(String message) {
        for (WebSocketSession session : WebSocketMessageHandler.getWebSocketSessions()) {
            try {
                session.sendMessage(new TextMessage(message));
                messageService.saveMessage(message);
            } catch (IOException e) {
                log.error("Error sending message to WebSocket session: {}", e.getMessage());
            }
        }
    }
}
