package ru.clinic.org.clinicorganizer.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.clinic.org.clinicorganizer.entity.Specialization;

public interface SpecializationRepository extends JpaRepository<Specialization,Integer> {
}
