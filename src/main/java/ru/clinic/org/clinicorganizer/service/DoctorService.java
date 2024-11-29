package ru.clinic.org.clinicorganizer.service;

import ru.clinic.org.clinicorganizer.dto.DoctorDto;
import ru.clinic.org.clinicorganizer.dto.DoctorDtoRequest;
import ru.clinic.org.clinicorganizer.entity.Doctor;

import java.util.List;
import java.util.Optional;

public interface DoctorService {

    List<DoctorDto> getDoctors();

    DoctorDto saveDoctor(DoctorDtoRequest doctorDtoRequest);

    void deleteDoctor(Integer id);

    DoctorDto updateDoctor(Integer id,DoctorDtoRequest doctorDtoRequest);

    Optional<DoctorDto> getDoctorById(Integer id);

    List<Doctor> findAllWithSpecializationsAndPatients();

}
