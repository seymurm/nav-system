package com.example.inhousenav.controller;

import com.example.inhousenav.model.dto.BaseStationDto;
import com.example.inhousenav.service.BaseStationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by seymurmanafov on 2023. 05. 26..
 */
@RequiredArgsConstructor

@RestController
@RequestMapping("/base-station")
public class BaseStationController {
    private final BaseStationService baseStationService;

    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable String id) {
        BaseStationDto baseStation = baseStationService.findById(id)
            .toDto();
        return ResponseEntity.ok(baseStation);
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody BaseStationDto dto) {
        BaseStationDto baseStation = baseStationService.save(dto);
        return ResponseEntity.ok(baseStation);
    }
}
