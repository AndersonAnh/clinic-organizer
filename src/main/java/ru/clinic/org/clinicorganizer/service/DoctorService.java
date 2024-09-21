package ru.clinic.org.clinicorganizer.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.clinic.org.clinicorganizer.entity.Doctor;
import ru.clinic.org.clinicorganizer.repo.DoctorRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DoctorService {
    private final DoctorRepository doctorRepository;

    public List<Doctor> getDoctors(){
        return doctorRepository.findAll();
    }
}
