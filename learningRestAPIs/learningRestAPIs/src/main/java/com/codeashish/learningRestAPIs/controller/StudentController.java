package com.codeashish.learningRestAPIs.controller;

import com.codeashish.learningRestAPIs.dto.AddStudentDto;
import com.codeashish.learningRestAPIs.dto.StudentDto;
import com.codeashish.learningRestAPIs.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public ResponseEntity<List<StudentDto>> getAllStudents() {
        return ResponseEntity.ok(studentService.getAllStudents());
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentDto> getStudentById(@PathVariable long id) {
        // In a real application, you would fetch the student by ID from the database
        return ResponseEntity.ok(studentService.getStudentById(id));
    }

    @PostMapping
    public ResponseEntity<StudentDto> createStudent(@RequestBody @Valid AddStudentDto addStudentDto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(studentService.createStudent(addStudentDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable long id) {
        studentService.deleteStudentById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudentDto> updateStudent(
            @PathVariable long id,
            @RequestBody AddStudentDto addStudentDto) {
        StudentDto updatedStudent = studentService.updateStudent(id, addStudentDto);
        return ResponseEntity.ok(updatedStudent);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<StudentDto> patchStudent(
            @PathVariable long id,
            @RequestBody AddStudentDto addStudentDto) {
        StudentDto patchedStudent = studentService.patchStudent(id, addStudentDto);
        return ResponseEntity.ok(patchedStudent);
    }

}
