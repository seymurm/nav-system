package com.example.inhousenav.controller;

import com.example.inhousenav.model.dao.MobileStation;
import com.example.inhousenav.model.dao.StationRegistration;
import com.example.inhousenav.model.dto.BaseStationDto;
import com.example.inhousenav.model.dto.MobileStationDto;
import com.example.inhousenav.repository.BaseMobileStationRepository;
import com.example.inhousenav.service.MobileStationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * Created by seymurmanafov on 2023. 05. 26..
 */
@RequiredArgsConstructor

@RestController
@RequestMapping("/mobile-station")
public class MobileStationController {
    private final MobileStationService mobileStationService;
    private final BaseMobileStationRepository baseMobileStationRepository;


    @GetMapping("/location/{id}")
    public ResponseEntity<?> getMobileStationLocation(@PathVariable String id) {
        MobileStation mobileStation = mobileStationService.findById(id);
        Optional<StationRegistration> stationRegistrationOptional =
            baseMobileStationRepository.findLastByMobileStationOrderByCreatedDesc(mobileStation);

        if (stationRegistrationOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(stationRegistrationOptional.get().getMobileStation());
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody MobileStationDto dto) {
        MobileStation mobileStation = mobileStationService.save(dto);
        return ResponseEntity.ok(mobileStation);
    }
}
