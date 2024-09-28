package ru.clinic.org.clinicorganizer.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.clinic.org.clinicorganizer.dto.DoctorDto;
import ru.clinic.org.clinicorganizer.dto.DoctorDtoRequest;
import ru.clinic.org.clinicorganizer.entity.Doctor;
import ru.clinic.org.clinicorganizer.entity.Specialization;
import ru.clinic.org.clinicorganizer.exception.DoctorNotFoundException;
import ru.clinic.org.clinicorganizer.exception.DoctorSpecializationException;
import ru.clinic.org.clinicorganizer.mapper.DoctorMapper;
import ru.clinic.org.clinicorganizer.repo.DoctorRepository;
import ru.clinic.org.clinicorganizer.repo.SpecializationRepository;

import java.util.List;

@Service
@RequiredArgsConstructor

public class DoctorService {

    private final DoctorRepository doctorRepository;

    private final DoctorMapper doctorMapper;

    private final SpecializationRepository specializationRepository;

    public List<Doctor> getDoctors() {
        return doctorRepository.findAll();
    }

    public DoctorDto saveDoctor(DoctorDtoRequest doctorDtoRequest) {
        Doctor doctor = doctorMapper.doctorDtoRequestToDoctor(doctorDtoRequest);

        if(doctorDtoRequest.specializationId() != null){
            Specialization specialization = specializationRepository.findById(doctorDtoRequest.specializationId())
                    .orElseThrow(()-> new DoctorSpecializationException("Не введена специализация"));
        }else {
            throw new DoctorSpecializationException("Не введена специализация");
        }

        Doctor saveDoctor = doctorRepository.save(doctor);
        return doctorMapper.doctorToDoctorDto(saveDoctor);
    }

    public void deleteDoctor(Integer id){
        doctorRepository.deleteById(id);
    }

    public DoctorDto updateDoctor(Integer id,DoctorDtoRequest doctorDtoRequest){
        Doctor doctor = doctorRepository.findById(id)
                .orElseThrow(()-> new DoctorNotFoundException("Такого сотрудника нет в базе данных"));

        if(doctorDtoRequest.specializationId() != null){
            Specialization specialization = specializationRepository.findById(doctorDtoRequest.specializationId())
                    .orElseThrow(()-> new DoctorSpecializationException("Не введена специализация"));
        }else {
            throw new DoctorSpecializationException("Не введена специализация");
        }
        Doctor updateDoctor = doctorRepository.save(doctor);
        return doctorMapper.doctorToDoctorDto(updateDoctor);
    }
}
