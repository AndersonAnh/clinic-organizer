package ru.clinic.org.clinicorganizer.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.clinic.org.clinicorganizer.entity.Doctor;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor,Integer> {
}
