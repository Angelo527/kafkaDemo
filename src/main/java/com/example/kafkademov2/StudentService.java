package com.example.kafkademov2;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    // Recupera tutti gli studenti
    public List<StudentEntity> getAllStudents() {
        return studentRepository.findAll();
    }

    // Recupera uno studente tramite ID
    public StudentEntity getStudentById(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Studente con ID " + id + " non trovato."));
    }

    // Aggiunge un nuovo studente
    @Transactional
    public StudentEntity addStudent(StudentRequest request) {
        StudentEntity student = new StudentEntity(request.name(), request.email());
        return studentRepository.save(student);
    }

    // Aggiorna le informazioni di uno studente
    @Transactional
    public void updateStudent(Long id, StudentRequest request) {
        StudentEntity student = studentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Studente con ID " + id + " non trovato."));

        student.setName(request.name());
        student.setEmail(request.email());
        studentRepository.save(student);
    }

    // Elimina uno studente tramite ID
    public void deleteStudent(Long id) {
        if (!studentRepository.existsById(id)) {
            throw new IllegalArgumentException("Studente con ID " + id + " non trovato.");
        }
        studentRepository.deleteById(id);
    }
}
