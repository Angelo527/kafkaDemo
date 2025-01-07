
package com.example.kafkademov2;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaListeners {

    private final MessageRepository messageRepository;

    public KafkaListeners(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @KafkaListener(topics = "topicName", groupId = "groupId")
    void listener(String data) {
        System.out.println("Received: " + data);

        // Salva il messaggio nel database
        MessageEntity messageEntity = new MessageEntity(data);
        messageRepository.save(messageEntity);
    }
}

