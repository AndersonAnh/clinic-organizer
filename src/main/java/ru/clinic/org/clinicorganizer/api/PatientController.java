package ru.clinic.org.clinicorganizer.api;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.clinic.org.clinicorganizer.entity.Patient;
import ru.clinic.org.clinicorganizer.service.PatientService;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class PatientController {
    private final PatientService patientService;

    @GetMapping("/patientsPage")
    public String getPatients(Model model){
        List<Patient> patients = patientService.findAll();
        model.addAttribute("patients",patients);
        return "patients/patients";
    }
}
