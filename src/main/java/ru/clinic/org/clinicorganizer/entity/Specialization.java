package ru.clinic.org.clinicorganizer.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "specializations", schema = "project")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@ToString(exclude = "doctors")
public class Specialization {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Integer id;
    @Column(name = "name")
    String name;

    public Specialization(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    @OneToMany(mappedBy = "specialization")
    @JsonIgnore
    private List<Doctor> doctors;
}
