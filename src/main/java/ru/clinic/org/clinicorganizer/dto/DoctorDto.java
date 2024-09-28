package ru.clinic.org.clinicorganizer.dto;

import lombok.Builder;

@Builder
public record DoctorDto(
        Integer id,
        String firstName,
        String lastName,
        Integer specializationId
) {
}
