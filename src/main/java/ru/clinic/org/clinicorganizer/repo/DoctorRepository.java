package ru.clinic.org.clinicorganizer.repo;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.clinic.org.clinicorganizer.entity.Doctor;

import java.util.List;

@Repository

public interface DoctorRepository extends JpaRepository<Doctor,Integer> {
    @EntityGraph(attributePaths = {"specialization", "patients"})
    @Query("select d from Doctor d left join fetch d.specialization left join fetch d.patients")
    List<Doctor> findAllWithSpecializationsAndPatients();

    @Query("select d from Doctor d left join fetch d.specialization")
    List<Doctor> findAllWithSpecializations();
}
