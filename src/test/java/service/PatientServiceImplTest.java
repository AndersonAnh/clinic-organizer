package service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.clinic.org.clinicorganizer.dto.PatientDto;
import ru.clinic.org.clinicorganizer.entity.Patient;
import ru.clinic.org.clinicorganizer.mapper.PatientMapper;
import ru.clinic.org.clinicorganizer.repo.PatientRepository;
import ru.clinic.org.clinicorganizer.service.PatientServiceImpl;
import util.PatientUtil;

import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PatientServiceImplTest {

    @Mock
    private PatientRepository patientRepository;
    @Mock
    private PatientMapper patientMapper;

    @InjectMocks
    private PatientServiceImpl patientServiceImpl;

    @Test
    void shouldFindPatient(){
        List<Patient> patients = PatientUtil.getPatientsList();
        when(patientRepository.findAllWithDoctors()).thenReturn(patients);
        var result = patientServiceImpl.findAll();
        Assertions.assertEquals(patients.size(),result.size());
        verify(patientRepository,times(1)).findAllWithDoctors();
    }

    @Test
    void shouldSavePatient(){
        PatientDto patientDto = PatientUtil.getPatientDto();
        Patient patient = PatientUtil.getPatientEntity();
        when(patientMapper.patientDtoToPatient(patientDto)).thenReturn(patient);
        patientServiceImpl.savePatient(patientDto);
        verify(patientRepository,times(1)).save(patient);
    }

    @Test
    void shouldDeletePatient(){
        patientServiceImpl.deletePatient(1);
        verify(patientRepository,times(1)).deleteById(1);
    }

    @Test
    void shouldUpdatePatient(){
        PatientDto patientDto = PatientUtil.getPatientDto();
        Patient patient = PatientUtil.getPatientEntity();
        Patient updatedPatient =Patient.builder()
                .id(1)
                .firstName("Joe")
                .lastName("Doe")
                .build();
        when(patientRepository.findById(1)).thenReturn(Optional.ofNullable(patient));
        when(patientRepository.save(patient)).thenReturn(updatedPatient);
        when(patientMapper.patientToPatientDto(updatedPatient)).thenReturn(patientDto);

        var result = patientServiceImpl.update(patientDto);
        Assertions.assertEquals(patientDto,result);
        verify(patientRepository,times(1)).findById(1);
        verify(patientRepository,times(1)).save(patient);
        verify(patientMapper,times(1)).patientToPatientDto(patient);
    }
}
