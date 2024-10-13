package ru.clinic.org.clinicorganizer.repo;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.clinic.org.clinicorganizer.entity.Patient;

import java.util.List;

public interface PatientRepository extends JpaRepository<Patient,Integer> {

    @EntityGraph(attributePaths = {"doctors"})
    @Query("select p from Patient p")
    List<Patient> findAllWithDoctors();
}
