package ru.clinic.org.clinicorganizer.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.clinic.org.clinicorganizer.dto.PatientDto;
import ru.clinic.org.clinicorganizer.entity.Patient;
import ru.clinic.org.clinicorganizer.mapper.PatientMapper;
import ru.clinic.org.clinicorganizer.repo.PatientRepository;

import java.util.List;
@Service
@RequiredArgsConstructor
public class PatientServiceImpl implements PatientService{

    private final PatientRepository patientRepository;

    private final PatientMapper patientMapper;
    @Override
    public List<Patient> findAll() {
        return patientRepository.findAllWithDoctors();
    }

    public void savePatient(PatientDto patientDto){
        Patient patient = patientMapper.patientDtoToPatient(patientDto);
        patientRepository.save(patient);
    }

    @Override
    public void deletePatient(Integer id) {
        patientRepository.deleteById(id);
    }
}
