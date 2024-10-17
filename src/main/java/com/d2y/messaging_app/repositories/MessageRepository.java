package com.d2y.messaging_app.repositories;

import com.d2y.messaging_app.entities.Message;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MessageRepository extends MongoRepository<Message, String> {
}

