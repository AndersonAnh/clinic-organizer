package util;

import ru.clinic.org.clinicorganizer.dto.SpecializationDto;
import ru.clinic.org.clinicorganizer.entity.Specialization;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SpecializationUtil {

    public static List<Specialization> getSpecializationList() {
        List<Specialization> specializations = new ArrayList<>();
        specializations.add(new Specialization(1, "Хирург"));
        specializations.add(new Specialization(2, "Уролог"));
        return specializations;
    }

    public static Optional<Specialization> getSpecializationOptionalType() {
        return Optional.ofNullable(Specialization.builder()
                .id(1)
                .name("Хирург")
                .build());
    }

    public static SpecializationDto getBuilderDto() {
        SpecializationDto specializationDto = SpecializationDto.builder()
                .name("Гинеколог")
                .build();
        return specializationDto;
    }

    public static Specialization getBuilderEntity(){
        Specialization specialization = Specialization.builder()
                .name("Стоматолог")
                .build();
        return specialization;
    }
}
