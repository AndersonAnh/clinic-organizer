package ru.clinic.org.clinicorganizer.service;

import ru.clinic.org.clinicorganizer.entity.Patient;

import java.util.List;

public interface PatientService {

    List<Patient> findAll();

}
