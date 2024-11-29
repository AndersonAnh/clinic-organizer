package ru.clinic.org.clinicorganizer.service;

import ru.clinic.org.clinicorganizer.dto.SpecializationDto;
import ru.clinic.org.clinicorganizer.entity.Specialization;
import java.util.List;
import java.util.Optional;

public interface SpecializationService {

    List<Specialization> getAllSpecialization();

    Optional<Specialization> findById(Integer id);

    void deleteSpecialization(Integer id);

    void saveSpecialization(SpecializationDto specializationDto);
}
