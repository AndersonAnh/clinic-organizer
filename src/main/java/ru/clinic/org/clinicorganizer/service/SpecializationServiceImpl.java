package ru.clinic.org.clinicorganizer.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.clinic.org.clinicorganizer.dto.SpecializationDto;
import ru.clinic.org.clinicorganizer.entity.Specialization;
import ru.clinic.org.clinicorganizer.mapper.SpecializationMapper;
import ru.clinic.org.clinicorganizer.repo.SpecializationRepository;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SpecializationServiceImpl implements SpecializationService{

    private final SpecializationRepository specializationRepository;

    private final SpecializationMapper specializationMapper;

    @Override
    public List<Specialization> getAllSpecialization() {
        return specializationRepository.findAll();
    }

    @Override
    public Optional<Specialization> findById(Integer id) {
        return specializationRepository.findById(id);
    }

    @Override
    public void deleteSpecialization(Integer id) {
        specializationRepository.deleteById(id);
    }

    @Override
    public void saveSpecialization(SpecializationDto specializationDto) {
        Specialization specialization = specializationMapper.fromDtoToEntity(specializationDto);
        specializationRepository.save(specialization);
    }
}
