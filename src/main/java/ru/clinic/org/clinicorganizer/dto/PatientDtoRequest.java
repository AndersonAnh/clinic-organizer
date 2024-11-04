package ru.clinic.org.clinicorganizer.dto;

import lombok.Builder;

import java.io.Serializable;
@Builder
public record PatientDtoRequest(String firstName,
                                String lastName,
                                Integer doctorId) implements Serializable {

}