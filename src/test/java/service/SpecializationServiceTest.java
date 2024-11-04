package service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.clinic.org.clinicorganizer.dto.SpecializationDto;
import ru.clinic.org.clinicorganizer.entity.Specialization;
import ru.clinic.org.clinicorganizer.mapper.SpecializationMapper;
import ru.clinic.org.clinicorganizer.repo.SpecializationRepository;
import ru.clinic.org.clinicorganizer.service.SpecializationServiceImpl;
import util.SpecializationUtil;

import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class SpecializationServiceTest {

    @Mock
    private SpecializationRepository specializationRepository;
    @Mock
    private SpecializationMapper specializationMapper;

    @InjectMocks
    private SpecializationServiceImpl specializationService;

    @Test
    void shouldReturnListOfSpecialization() {
        //подготавливаем данные для теста
        List<Specialization> specializations = SpecializationUtil.getSpecializationList();
        //настраиваем поведение репозитория
        when(specializationRepository.findAll()).thenReturn(specializations);
        //результат работы метода
        var result = specializationService.getAllSpecialization();
        //сравнение ожидаемого и фактического результата
        Assertions.assertEquals(specializations.size(),result.size());
        //проверка того что обращения в репозиторий было один раз
        verify(specializationRepository,times(1)).findAll();
    }

    @Test
    void shouldReturnSpecializationById(){
        Optional<Specialization> specialization = SpecializationUtil.getSpecializationOptionalType();
        when(specializationRepository.findById(2)).thenReturn(specialization);
        var result = specializationService.findById(2);
        Assertions.assertEquals(specialization,result);
        verify(specializationRepository,times(1)).findById(2);
    }

    @Test
    void shouldDeleteSpecializationById(){
        Integer specializationId = 1;
        specializationService.deleteSpecialization(specializationId);
        verify(specializationRepository,times(1)).deleteById(specializationId);
    }

    @Test
    void shouldSaveSpecialization(){
        //Это то,что заходит в метод- DTO джейсон который передан с фронта
        SpecializationDto specializationDto = SpecializationUtil.getBuilderDto();
        //Это то,что должны сохранить в БД-entity
        Specialization specialization = SpecializationUtil.getBuilderEntity();
        //перевести то что заходит в то что нужно сохранить
        when(specializationMapper.fromDtoToEntity(specializationDto)).thenReturn(specialization);
        specializationService.saveSpecialization(specializationDto);
        verify(specializationRepository,times(1)).save(specialization);
    }
}
