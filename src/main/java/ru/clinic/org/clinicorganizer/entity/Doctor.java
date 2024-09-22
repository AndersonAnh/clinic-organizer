package ru.clinic.org.clinicorganizer.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "doctors", schema = "project")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
            @Column(name = "id")
    Integer id;
    @Column(name = "first_name")
    String firstName;
    @Column(name = "last_name")
    String lastName;
    @Column(name = "specialization_id")
    Integer specializationId;

    @ManyToOne
    @JoinColumn(name = "specialization_id",insertable = false,updatable = false)
    Specialization specialization;
}
