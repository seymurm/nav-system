package com.example.inhousenav.service.impl;

import com.example.inhousenav.model.dao.MobileStation;
import com.example.inhousenav.model.dto.MobileStationDto;
import com.example.inhousenav.repository.MobileStationRepository;
import com.example.inhousenav.service.MobileStationService;
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
public class MobileStationServiceImpl implements MobileStationService {
    private final MobileStationRepository mobileStationRepository;

    @Override
    public MobileStation findById(String id) {
        return mobileStationRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Mobile station not found"));
    }

    @Override
    public MobileStation save(MobileStationDto dto) {
        return mobileStationRepository.save(dto.toDao());
    }
}
