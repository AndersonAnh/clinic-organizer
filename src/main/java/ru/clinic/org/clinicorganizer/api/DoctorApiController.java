package ru.clinic.org.clinicorganizer.api;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.clinic.org.clinicorganizer.dto.DoctorDto;
import ru.clinic.org.clinicorganizer.dto.DoctorDtoRequest;
import ru.clinic.org.clinicorganizer.entity.Doctor;
import ru.clinic.org.clinicorganizer.exception.DoctorNotFoundException;
import ru.clinic.org.clinicorganizer.exception.DoctorSpecializationException;
import ru.clinic.org.clinicorganizer.service.DoctorServiceImpl;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/doctor")
@RequiredArgsConstructor
@Slf4j
public class DoctorApiController {
    private final DoctorServiceImpl doctorService;

    @GetMapping
    public ResponseEntity <List<Doctor>> getDoctors(){
        log.debug("Получен список сотрудников");
        return new ResponseEntity<>(doctorService.getDoctors(), HttpStatus.OK);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DoctorDto> createDoctor(@RequestBody DoctorDtoRequest doctorDtoRequest) {
        log.debug("Создание нового сотрудника: {}",doctorDtoRequest);
        return new ResponseEntity<>(doctorService.saveDoctor(doctorDtoRequest),HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public HttpStatus deleteDoctor(@PathVariable Integer id){
        log.debug("Удалили сотрудника с ID: {}}",id);
        doctorService.deleteDoctor(id);
        return HttpStatus.OK;
    }

    @PatchMapping("/{id}")
    public ResponseEntity<DoctorDto> updateDoctor(@PathVariable Integer id,@RequestBody DoctorDtoRequest doctorDtoRequest){
        log.debug("Обновляется сотрудник с ID: {}",id);
        try{
            DoctorDto updateDoctor = doctorService.updateDoctor(id,doctorDtoRequest);
            return new ResponseEntity<>(updateDoctor,HttpStatus.OK);
        }catch (DoctorNotFoundException | DoctorSpecializationException e){
            log.error("Ошибка при обновлении сотрудника с id {}:{}",id,e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<DoctorDto>> getDoctorById(@PathVariable Integer id){
        log.debug("Получили доктора по Id: {}",id);
        return new ResponseEntity<>(doctorService.getDoctorById(id),HttpStatus.OK);
    }
}
