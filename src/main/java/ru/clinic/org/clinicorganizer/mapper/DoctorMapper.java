package ru.clinic.org.clinicorganizer.mapper;

import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import ru.clinic.org.clinicorganizer.dto.DoctorDto;
import ru.clinic.org.clinicorganizer.dto.DoctorDtoRequest;
import ru.clinic.org.clinicorganizer.entity.Doctor;

//этот интерфейс маппит из сущности в Дто и из Дто в сущность
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring",
        builder = @Builder(disableBuilder = true))
public interface DoctorMapper {

    Doctor doctorDtoToDoctor(DoctorDto doctorDto);

    DoctorDto doctorToDoctorDto(Doctor entity);

    Doctor doctorDtoRequestToDoctor(DoctorDtoRequest doctorDtoRequest);

    DoctorDtoRequest doctorToDoctorDtoRequest(Doctor entity);
}
