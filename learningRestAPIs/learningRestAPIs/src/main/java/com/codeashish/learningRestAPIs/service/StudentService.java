package com.codeashish.learningRestAPIs.service;

import com.codeashish.learningRestAPIs.dto.AddStudentDto;
import com.codeashish.learningRestAPIs.dto.StudentDto;
import com.codeashish.learningRestAPIs.entity.Student;

import java.util.List;

public interface StudentService {

    List<StudentDto> getAllStudents();

    StudentDto getStudentById(long id);

    StudentDto createStudent(AddStudentDto addStudentDto);

    void deleteStudentById(long id);

    StudentDto updateStudent(long id, AddStudentDto addStudentDto);

    StudentDto patchStudent(long id, AddStudentDto addStudentDto);
}
