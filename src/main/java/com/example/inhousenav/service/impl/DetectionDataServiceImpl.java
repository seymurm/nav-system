package com.example.inhousenav.service.impl;

import com.example.inhousenav.model.dao.StationRegistration;
import com.example.inhousenav.model.dao.BaseStation;
import com.example.inhousenav.model.dao.MobileStation;
import com.example.inhousenav.model.dao.StationRegistrationKey;
import com.example.inhousenav.model.dto.DetectionDataRequest;
import com.example.inhousenav.repository.BaseMobileStationRepository;
import com.example.inhousenav.service.BaseStationService;
import com.example.inhousenav.service.DetectionDataService;
import com.example.inhousenav.service.MobileStationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * Created by seymurmanafov on 2023. 05. 26..
 */
@Slf4j
@RequiredArgsConstructor

@Service
public class DetectionDataServiceImpl implements DetectionDataService {
    private final BaseStationService baseStationService;
    private final MobileStationService mobileStationService;
    private final BaseMobileStationRepository baseMobileStationRepository;

    @Override
    public void saveDetectionData(DetectionDataRequest detectionData) {
        BaseStation baseStation = baseStationService.findById(detectionData.getBaseStationId());
        MobileStation mobileStation = mobileStationService.findById(detectionData.getMobileStationRequestList().get(0).getUuid());

        StationRegistrationKey  stationRegistrationKey = new StationRegistrationKey();
        stationRegistrationKey.setBaseStationId(baseStation.getUuid());
        stationRegistrationKey.setMobileStationId(mobileStation.getUuid());

        StationRegistration stationRegistration = new StationRegistration();
        stationRegistration.setId(stationRegistrationKey);

        //save
        baseMobileStationRepository.save(stationRegistration);
    }
}
