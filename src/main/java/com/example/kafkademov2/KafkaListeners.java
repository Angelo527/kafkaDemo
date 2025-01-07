
package com.example.kafkademov2;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaListeners {

    private final StudentRepository studentRepository;

    public KafkaListeners(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @KafkaListener(topics = "topicName", groupId = "groupId")
    @KafkaListener(topics = "topicName", groupId = "groupId")
    @KafkaListener(topics = "topicName", groupId = "groupId")
    void listener(String data) {
        System.out.println("Received: " + data);

        // Suddividi il messaggio ricevuto in ID, nome ed email
        String[] parts = data.split(",");

        // Verifica che la stringa sia corretta
        if (parts.length != 3) {
            System.out.println("Invalid data format. Expected: id,name,email");
            return;
        }

        // Parsing dei dati
        Long id = Long.parseLong(parts[0].trim());
        String name = parts[1].trim();
        String email = parts[2].trim();

        // Crea l'entità StudentEntity con i dati corretti
        StudentEntity studentEntity = new StudentEntity(id, name, email);

        // Salva nel database
        studentRepository.save(studentEntity);

        System.out.println("Student saved: " + studentEntity);
    }


}

