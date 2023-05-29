package com.example.inhousenav.service;

import com.example.inhousenav.model.dao.BaseStation;
import com.example.inhousenav.model.dto.BaseStationDto;

/**
 * Created by seymurmanafov on 2023. 05. 26..
 */
public interface BaseStationService {
    BaseStation findById(String baseStationId);

    BaseStationDto save(BaseStationDto dto);
    BaseStationDto save(BaseStation dto);
}
