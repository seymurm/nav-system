package com.example.inhousenav.controller;

import com.example.inhousenav.model.dto.DetectionDataRequest;
import com.example.inhousenav.service.DetectionDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by seymurmanafov on 2023. 05. 26..
 */
@RequiredArgsConstructor

@RestController
public class DetectionDataController {

    private final DetectionDataService detectionDataService;

    @PostMapping("/detection-data")
    public ResponseEntity<?> saveDetectionData(@RequestBody DetectionDataRequest detectionData) {
        detectionDataService.saveDetectionData(detectionData);
        return ResponseEntity.ok().build();
    }
}
