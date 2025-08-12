package com.codeashish.learningRestAPIs.repository;

import com.codeashish.learningRestAPIs.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    // Custom query methods can be defined here if needed
    // For example:
    // List<Student> findByName(String name);
}
