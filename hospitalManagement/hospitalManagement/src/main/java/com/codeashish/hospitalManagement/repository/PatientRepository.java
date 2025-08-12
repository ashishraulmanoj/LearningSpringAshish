package com.codeashish.hospitalManagement.repository;

import com.codeashish.hospitalManagement.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {


}
