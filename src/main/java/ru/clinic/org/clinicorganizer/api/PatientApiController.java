package ru.clinic.org.clinicorganizer.api;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
        return ResponseEntity.ok(patientService.findAll());

    }
}
