package service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.clinic.org.clinicorganizer.dto.DoctorDto;
import ru.clinic.org.clinicorganizer.dto.DoctorDtoRequest;
import ru.clinic.org.clinicorganizer.entity.Doctor;
import ru.clinic.org.clinicorganizer.entity.Specialization;
import ru.clinic.org.clinicorganizer.exception.DoctorNotFoundException;
import ru.clinic.org.clinicorganizer.exception.DoctorSpecializationException;
import ru.clinic.org.clinicorganizer.mapper.DoctorMapper;
import ru.clinic.org.clinicorganizer.repo.DoctorRepository;
import ru.clinic.org.clinicorganizer.repo.SpecializationRepository;
import ru.clinic.org.clinicorganizer.service.DoctorServiceImpl;
import util.DoctorUtil;

import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class DoctorServiceImplTest {
    @Mock
    private DoctorRepository doctorRepository;
    @Mock
    private DoctorMapper doctorMapper;
    @Mock
    private SpecializationRepository specializationRepository;
    @InjectMocks
    DoctorServiceImpl doctorService;

    private Doctor mockDoctor;
    private DoctorDto mockDoctorDto;
    private DoctorDtoRequest mockDoctorDtoRequest;

    @BeforeEach
    void setUp() {
        mockDoctor = Doctor.builder()
                .id(1)
                .firstName("firstName")
                .lastName("lastName")
                .specializationId(2)
                .build();

        mockDoctorDto = DoctorDto.builder()
                .id(1)
                .firstName("firstName")
                .lastName("lastName")
                .build();

        mockDoctorDtoRequest = DoctorDtoRequest.builder()
                .firstName("firstName")
                .lastName("lastName")
                .specializationId(1)
                .build();
    }

    @Test
    void shouldReturnListOfDoctors() {

        List<Doctor> doctors = DoctorUtil.getDoctorsList();

        when(doctorRepository.findAll()).thenReturn(doctors);
        List<Doctor> result = doctorService.getDoctors();

        Assertions.assertFalse(result.isEmpty());
        Assertions.assertEquals(3, result.size());
    }

    @Test
    void shouldReturnDoctorById() {

        when(doctorRepository.findById(1)).thenReturn(Optional.ofNullable(mockDoctor));
        when(doctorMapper.doctorToDoctorDto(mockDoctor)).thenReturn(mockDoctorDto);

        Optional<DoctorDto> result = doctorService.getDoctorById(1);

        Assertions.assertTrue(result.isPresent());
        Assertions.assertEquals(result.get(), mockDoctorDto);
    }

    @Test
    void shouldSaveDoctor() {

        when(doctorMapper.doctorDtoRequestToDoctor(mockDoctorDtoRequest)).thenReturn(mockDoctor);
        when(doctorRepository.save(mockDoctor)).thenReturn(mockDoctor);
        when(doctorMapper.doctorToDoctorDto(mockDoctor)).thenReturn(mockDoctorDto);

        DoctorDto result = doctorService.saveDoctor(mockDoctorDtoRequest);

        Assertions.assertEquals(result, mockDoctorDto);
    }

    @Test
    void shouldUpdateDoctorTest(){

        Specialization specialization = new Specialization(3,"Хирург");

        when(doctorRepository.findById(1)).thenReturn(Optional.ofNullable(mockDoctor));
        when(specializationRepository.findById(mockDoctorDtoRequest.specializationId())).thenReturn(Optional.of(specialization));
        when(doctorRepository.save(mockDoctor)).thenReturn(mockDoctor);
        when(doctorMapper.doctorToDoctorDto(mockDoctor)).thenReturn(mockDoctorDto);

        DoctorDto result = doctorService.updateDoctor(1,mockDoctorDtoRequest);

        Assertions.assertEquals(result,mockDoctorDto);
    }

    @Test
    void shouldThrowDoctorNotFoundExceptionWhenUpdateDoctor(){

        when(doctorRepository.findById(1)).thenReturn(Optional.empty());

        Assertions.assertThrows(DoctorNotFoundException.class,()-> {
            doctorService.updateDoctor(1,mockDoctorDtoRequest);
        });
    }

    @Test
    void shouldThrowDoctorSpecializationExceptionWhenUpdateDoctor(){

        DoctorDtoRequest withoutSpecializationId = DoctorDtoRequest.builder()
                .firstName("firstName")
                .lastName("lastName")
                .specializationId(null)
                .build();

        when(doctorRepository.findById(1)).thenReturn(Optional.ofNullable(mockDoctor));

        Assertions.assertThrows(DoctorSpecializationException.class,()-> {
            doctorService.updateDoctor(1,mockDoctorDtoRequest);
        });
    }

    @Test
    void shouldDeleteDoctorTest(){

        doctorService.deleteDoctor(2);

        verify(doctorRepository,times(1)).deleteById(2);
    }
}
