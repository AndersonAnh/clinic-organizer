package util;

import ru.clinic.org.clinicorganizer.dto.PatientDto;
import ru.clinic.org.clinicorganizer.dto.PatientDtoRequest;
import ru.clinic.org.clinicorganizer.entity.Patient;

import java.util.ArrayList;
import java.util.List;

public class PatientUtil {

    public static List<Patient> getPatientsList(){
        List<Patient> patients = new ArrayList<>();
        patients.add(new Patient(1,"Joe","Doe"));
        patients.add(new Patient(1,"Joe","Doe"));
        patients.add(new Patient(1,"Joe","Doe"));

        return patients;
    }

    public static Patient getPatientEntity(){
        return Patient.builder()
                .id(1)
                .firstName("Joe")
                .lastName("Doe")
                .build();
    }

    public static PatientDtoRequest getPatientDtoRequest(){
        return PatientDtoRequest.builder()
                .firstName("Joe")
                .lastName("Doe")
                .doctorId(1)
                .build();
    }
    public static PatientDto getPatientDto(){
        return PatientDto.builder()
                .id(1)
                .firstName("Joe")
                .lastName("Doe")
                .build();
    }

}
