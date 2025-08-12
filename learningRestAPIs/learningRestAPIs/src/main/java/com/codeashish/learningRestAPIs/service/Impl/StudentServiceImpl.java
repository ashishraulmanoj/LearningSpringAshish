package com.codeashish.learningRestAPIs.service.Impl;

import com.codeashish.learningRestAPIs.dto.AddStudentDto;
import com.codeashish.learningRestAPIs.dto.StudentDto;
import com.codeashish.learningRestAPIs.entity.Student;
import com.codeashish.learningRestAPIs.repository.StudentRepository;
import com.codeashish.learningRestAPIs.service.StudentService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository, ModelMapper modelMapper, ModelMapper modelMapper1) {
        this.studentRepository = studentRepository;
        this.modelMapper = modelMapper1;
    }

    private final ModelMapper modelMapper;

    @Override
    public List<StudentDto> getAllStudents() {
        List<Student> students = studentRepository.findAll();
        return students.stream()
                .map(student -> modelMapper.map(student, StudentDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public StudentDto getStudentById(long id) {
        return studentRepository .findById(id)
                .map(student -> modelMapper.map(student, StudentDto.class))
                .orElseThrow(() -> new RuntimeException("Student not found with id: " + id));
    }

    @Override
    public StudentDto createStudent(AddStudentDto addStudentDto) {
        Student newstudent = modelMapper.map(addStudentDto, Student.class);
        Student savedStudent = studentRepository.save(newstudent);
        return modelMapper.map(savedStudent, StudentDto.class);
    }

    @Override
    public void deleteStudentById(long id) {
        if(studentRepository.existsById(id)) {
            studentRepository.deleteById(id);
        } else {
            throw new RuntimeException("Student not found with id: " + id);
        }


    }

    @Override
    public StudentDto updateStudent(long id, AddStudentDto addStudentDto) {
        Student existingStudent = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found with id: " + id));

        // Use ModelMapper to update fields
        modelMapper.map(addStudentDto, existingStudent);

        Student updatedStudent = studentRepository.save(existingStudent);
        return modelMapper.map(updatedStudent, StudentDto.class);
    }

    @Override
    public StudentDto patchStudent(long id, AddStudentDto addStudentDto) {
        Student existingStudent = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found with id: " + id));

        if (addStudentDto.getName() != null) {
            existingStudent.setName(addStudentDto.getName());
        }
        if (addStudentDto.getEmail() != null) {
            existingStudent.setEmail(addStudentDto.getEmail());
        }
        // Add more fields as needed

        Student updatedStudent = studentRepository.save(existingStudent);
        return modelMapper.map(updatedStudent, StudentDto.class);
    }

}

