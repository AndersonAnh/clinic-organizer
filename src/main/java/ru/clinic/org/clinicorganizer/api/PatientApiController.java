package ru.clinic.org.clinicorganizer.api;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.clinic.org.clinicorganizer.dto.PatientDto;
import ru.clinic.org.clinicorganizer.entity.Patient;
import ru.clinic.org.clinicorganizer.service.PatientService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/patient")
@Slf4j
@RequiredArgsConstructor
public class PatientApiController {

    private final PatientService patientService;

    @GetMapping
    public ResponseEntity<List<Patient>> findAll(){
        log.debug("Получили список пациентов");
        return ResponseEntity.ok(patientService.findAll());
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void save(@RequestBody PatientDto patientDto){
        log.debug("Сохранили список пациентов");
    patientService.savePatient(patientDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        log.debug("Удалили пациента по id : {} ",id);
        patientService.deletePatient(id);
    }
}
