package com.example.kafkademov2;


import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.messaging.core.MessageReceivingOperations;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/messages")

public class MessageController {

    private KafkaTemplate<String, String> kafkaTemplate;


    public MessageController(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }


    @PostMapping
    public void publish(@RequestBody MessageRequest request) {
        kafkaTemplate.send("topicName", request.MessageRequest());
    }
}
