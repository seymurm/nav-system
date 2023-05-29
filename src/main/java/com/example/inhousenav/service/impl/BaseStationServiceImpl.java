package com.example.inhousenav.service.impl;

import com.example.inhousenav.model.dao.BaseStation;
import com.example.inhousenav.model.dto.BaseStationDto;
import com.example.inhousenav.repository.BaseStationRepository;
import com.example.inhousenav.service.BaseStationService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * Created by seymurmanafov on 2023. 05. 26..
 */
@Slf4j
@RequiredArgsConstructor

@Service
public class BaseStationServiceImpl implements BaseStationService {
    private final BaseStationRepository baseStationRepository;

    @Override
    public BaseStation findById(String id) {
        return baseStationRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("BaseStation not found with the given id"));
    }

    @Override
    public BaseStationDto save(BaseStationDto dto) {
        return baseStationRepository.save(dto.toDao())
            .toDto();
    }

    @Override
    public BaseStationDto save(BaseStation dto) {
        return baseStationRepository.save(dto)
            .toDto();
    }
}
