package com.codeashish.hospitalManagement;

import com.codeashish.hospitalManagement.entity.Patient;
import com.codeashish.hospitalManagement.repository.PatientRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class PatientTests {

    @Autowired
    private PatientRepository patientRepository;

    @Test
    public void testPatientRepository() {
        List<Patient> patients = patientRepository.findAll();
        System.out.println(patients);
    }

}
