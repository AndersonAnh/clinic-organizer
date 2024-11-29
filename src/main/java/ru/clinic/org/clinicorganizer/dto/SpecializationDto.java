package ru.clinic.org.clinicorganizer.dto;

import lombok.Builder;

import java.io.Serializable;

@Builder
public record SpecializationDto(
        String name
)implements Serializable {
}
