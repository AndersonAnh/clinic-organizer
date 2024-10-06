package util;

import ru.clinic.org.clinicorganizer.dto.DoctorDto;
import ru.clinic.org.clinicorganizer.dto.DoctorDtoRequest;
import ru.clinic.org.clinicorganizer.entity.Doctor;
import ru.clinic.org.clinicorganizer.entity.Specialization;

import java.util.ArrayList;
import java.util.List;

public class DoctorUtil {

    public static List<Doctor> getDoctorsList() {
        List<Doctor> doctors = new ArrayList<>();
        doctors.add(new Doctor(2, "Joe", "Doe", 1, new Specialization(1, "Dentist")));
        doctors.add(new Doctor(2, "Joe", "Doe", 1, new Specialization(1, "Dentist")));
        doctors.add(new Doctor(2, "Joe", "Doe", 1, new Specialization(1, "Dentist")));
        return doctors;
    }

    public static Doctor getDoctorEntity() {
        return Doctor.builder()
                .id(1).firstName("John")
                .lastName("Doe").specializationId(1)
                .specialization(new Specialization(1, "Dentist")).build();
    }

    public static DoctorDtoRequest getDoctorDtoRequest() {
        return DoctorDtoRequest.builder()
                .firstName("John").lastName("Doe")
                .specializationId(1).build();
    }

    public static DoctorDto getDoctorDto() {
        return DoctorDto.builder()
                .id(1).firstName("John")
                .lastName("Doe").specializationId(1)
                .build();
    }

   /* public static Set<Patient> getPatientsSet() {
        return Set.of(new Patient(1,"John","Doe"),            new Patient(1,"Jane","Doe"));
    }*/
}
