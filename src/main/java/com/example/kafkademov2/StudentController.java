package com.example.kafkademov2;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    // Recupera tutti gli studenti
    @GetMapping
    public List<StudentEntity> getAllStudents() {
        return studentService.getAllStudents();
    }

    // Recupera uno studente specifico tramite ID
    @GetMapping("{id}")
    public StudentEntity getStudentById(@PathVariable Long id) {
        return studentService.getStudentById(id);
    }

    // Aggiunge un nuovo studente
    @PostMapping
    public void addStudent(@RequestBody StudentRequest request) {
        studentService.addStudent(request);
    }

    // Aggiorna le informazioni di uno studente
    @PutMapping("{id}")
    public void updateStudent(@PathVariable Long id, @RequestBody StudentRequest request) {
        studentService.updateStudent(id, request);
    }

    // Elimina uno studente tramite ID
    @DeleteMapping("{id}")
    public void deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
    }
}
