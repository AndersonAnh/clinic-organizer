package ru.clinic.org.clinicorganizer.api;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.clinic.org.clinicorganizer.entity.Doctor;
import ru.clinic.org.clinicorganizer.service.DoctorService;

import java.util.List;

@RestController
@RequestMapping("api/v1/doctor")
@RequiredArgsConstructor
public class DoctorApiController {
    private final DoctorService doctorService;

    @GetMapping
    public ResponseEntity <List<Doctor>> getDoctors(){
        return new ResponseEntity<>(doctorService.getDoctors(), HttpStatus.OK);
    }
}
