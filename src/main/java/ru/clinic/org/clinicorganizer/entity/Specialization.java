package ru.clinic.org.clinicorganizer.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Table(name = "specializations", schema = "project")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder

public class Specialization {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Integer id;
    @Column(name = "name")
    String name;

    @OneToMany(mappedBy = "specialization")
    private List<Doctor> doctors;
}
