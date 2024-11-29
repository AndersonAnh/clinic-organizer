package ru.clinic.org.clinicorganizer.dto;

import lombok.Builder;

import java.io.Serializable;

@Builder
public record DoctorDtoRequest(
        String firstName,
        String lastName,
        Integer specializationId
) implements Serializable {
}
