package com.zaid.patel.REST_APIs.controller;

import com.zaid.patel.REST_APIs.DTO.StudentDTO;
import com.zaid.patel.REST_APIs.DTO.AddStudentDto;
import com.zaid.patel.REST_APIs.services.StudentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
public class StudentController {


    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/students")                                                              //without status code
    public List<StudentDTO> getStudents(){
        return studentService.getAllStudents();
    }
    @GetMapping("/students/{id}")                                                       // With status code using Response Entity
    public ResponseEntity<StudentDTO > getStudetsById(@PathVariable int id){
        return ResponseEntity.status(HttpStatus.OK).body(studentService.getStudetsById(id));
    }
    @PostMapping("/students")
    public ResponseEntity<StudentDTO> createNewStudent(@RequestBody @Valid AddStudentDto addStudentDTO ){
        StudentDTO createdStudent = studentService.createNewStudent(addStudentDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdStudent);
    }
    @DeleteMapping("/students/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable int id){
        studentService.deleteStudent(id);
        return ResponseEntity.noContent().build();
    }
    @PutMapping("/students/{id}")
    public ResponseEntity<StudentDTO> updateStudent(@PathVariable int id, @RequestBody @Valid AddStudentDto addStudentDto){
        return ResponseEntity.ok(studentService.updateStudent(id, addStudentDto));
    }
    @PatchMapping("/students/{id}")
    public ResponseEntity<StudentDTO> updatePartialStudent(@PathVariable int id, @RequestBody Map<String, Object> updates){
        return ResponseEntity.ok(studentService.updatePartialStudent(id, updates));
    }
}
