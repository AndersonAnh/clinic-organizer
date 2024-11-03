package ru.clinic.org.clinicorganizer.api;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.clinic.org.clinicorganizer.entity.Doctor;
import ru.clinic.org.clinicorganizer.service.DoctorService;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class DoctorController {
    private final DoctorService doctorService;

    @GetMapping("/doctorsPage")
    public String getDoctors(Model model){
        List<Doctor> doctors = doctorService.findAllWithSpecializationsAndPatients();
        model.addAttribute("doctors",doctors);
        return "doctors/doctors";
    }

}
