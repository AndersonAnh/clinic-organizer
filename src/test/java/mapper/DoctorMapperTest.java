package mapper;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import ru.clinic.org.clinicorganizer.dto.DoctorDto;
import ru.clinic.org.clinicorganizer.entity.Doctor;
import ru.clinic.org.clinicorganizer.mapper.DoctorMapper;
import util.DoctorUtil;

public class DoctorMapperTest {

    private final String FIRST_NAME = "John";
    private final String LAST_NAME = "Doe";
    private final Integer SPECIALIZATION_ID = 1;
    private final DoctorMapper doctorMapper = Mappers.getMapper(DoctorMapper.class);

    @Test

    void mapEntityToDtoTest(){

        Doctor doctor = DoctorUtil.getDoctorEntity();

        DoctorDto doctorDto = doctorMapper.doctorToDoctorDto(doctor);

        Assertions.assertNotNull(doctorDto);
        Assertions.assertNotNull(doctorDto.id());
        Assertions.assertEquals(FIRST_NAME,doctorDto.firstName());
        Assertions.assertEquals(LAST_NAME,doctorDto.lastName());
        Assertions.assertEquals(SPECIALIZATION_ID,doctorDto.specializationId());
    }

    @Test
    void mapDtoToEntityTest(){

        DoctorDto doctorDto = DoctorUtil.getDoctorDto();

        Doctor doctor = doctorMapper.doctorDtoToDoctor(doctorDto);

        Assertions.assertNotNull(doctor);
        Assertions.assertNotNull(doctor.getId());
        Assertions.assertEquals(FIRST_NAME,doctor.getFirstName());
        Assertions.assertEquals(LAST_NAME,doctor.getLastName());
        Assertions.assertEquals(SPECIALIZATION_ID,doctor.getSpecializationId());
    }
}
