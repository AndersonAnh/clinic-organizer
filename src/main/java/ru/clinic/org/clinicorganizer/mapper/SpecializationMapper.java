package ru.clinic.org.clinicorganizer.mapper;

import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import ru.clinic.org.clinicorganizer.dto.SpecializationDto;
import ru.clinic.org.clinicorganizer.entity.Specialization;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring",
        builder = @Builder(disableBuilder = true))
public interface SpecializationMapper {

    Specialization fromDtoToEntity(SpecializationDto specializationDto);

    SpecializationDto fromEntityToDto(Specialization specialization);


}
