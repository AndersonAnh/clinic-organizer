package ru.clinic.org.clinicorganizer.dto;

import lombok.Builder;

@Builder
public record DoctorDtoRequest(

        String firstName,
        String lastName,
        Integer specializationId
) {
}
