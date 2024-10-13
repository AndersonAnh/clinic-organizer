package ru.clinic.org.clinicorganizer.api;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.clinic.org.clinicorganizer.dto.SpecializationDto;
import ru.clinic.org.clinicorganizer.entity.Specialization;
import ru.clinic.org.clinicorganizer.service.SpecializationService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/specialization")
@Slf4j
@RequiredArgsConstructor
public class SpecializationApiController {

    private final SpecializationService specializationService;

    @GetMapping
    public ResponseEntity<List<Specialization>> findAll(){
        log.debug("Мы получили список новых специализаций");
        return new ResponseEntity<>(specializationService.getAllSpecialization(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Specialization>> getSpecializationById(@PathVariable Integer id){
        log.debug("Получен специализация по ID: {}",id);
        return new ResponseEntity<>(specializationService.findById(id),HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public HttpStatus deleteSpecializationById(@PathVariable Integer id){
        specializationService.deleteSpecialization(id);
        log.debug("Удалена специализация по Id: {}",id);
        return HttpStatus.OK;
    }
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void saveSpecialization(@RequestBody SpecializationDto specializationDto){
        log.debug("Сохранение спициализации: {}",specializationDto);
        specializationService.saveSpecialization(specializationDto);
    }
}
