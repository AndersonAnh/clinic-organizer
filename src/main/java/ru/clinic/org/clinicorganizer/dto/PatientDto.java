package ru.clinic.org.clinicorganizer.dto;

import lombok.Builder;

import java.io.Serializable;

@Builder

public record PatientDto(
    String firstName,
    String lastName
)implements Serializable {
}
