package com.example.inhousenav.service;

import com.example.inhousenav.model.dao.MobileStation;
import com.example.inhousenav.model.dto.MobileStationDto;

/**
 * Created by seymurmanafov on 2023. 05. 26..
 */
public interface MobileStationService {
    MobileStation findById(String id);

    MobileStation save(MobileStationDto dto);
}
