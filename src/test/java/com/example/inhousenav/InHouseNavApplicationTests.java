package com.example.inhousenav;

import com.example.inhousenav.controller.DetectionDataController;
import com.example.inhousenav.controller.MobileStationController;
import com.example.inhousenav.model.dto.DetectionDataRequest;
import com.example.inhousenav.model.dto.MobileStationDto;
import com.example.inhousenav.service.DetectionDataService;
import com.example.inhousenav.service.MobileStationService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InHouseNavigationSystemApplicationTests {
    @Autowired
    private DetectionDataService detectionDataService;

    @Autowired
    private MobileStationService mobileStationService;

    @Autowired
    private MobileStationController mobileStationLocationController;

    @Autowired
    private DetectionDataController detectionDataController;

    @Test
    public void testSaveDetectionData() {
        // Create a detection data object
        DetectionDataRequest detectionData = new DetectionDataRequest(1, 2, LocalDateTime.now());

        // Save the detection data to the database
        detectionDataController.saveDetectionData(detectionData);

        // Retrieve the detection data from the database
        DetectionDataRequest savedDetectionData = detectionDataService.getDetectionDataById(detectionData.getId());

        assertEquals(detectionData.getId(), savedDetectionData.getId());
        assertEquals(detectionData.getMobileStationId(), savedDetectionData.getMobileStationId());
        assertEquals(detectionData.getTimestamp(), savedDetectionData.getTimestamp());
    }

    @Test
    public void testGetMobileStationLocation() {
        MobileStationDto mobileStation = new MobileStationDto(1, 12.345, 67.890);

        mobileStationService.saveMobileStation(mobileStation);

        // Query the REST endpoint to retrieve the mobile station's location
        ResponseEntity<?> response = mobileStationLocationController.getMobileStationLocation(1);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(mobileStation, response.getBody());
    }

    @Test
    public void testGetMobileStationLocationNotFound() {
        // Query the REST endpoint to retrieve a non-existent mobile station's location
        ResponseEntity<?> response = mobileStationLocationController.getMobileStationLocation(100);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }
}
