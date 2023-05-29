package com.example.inhousenav.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.lang.NonNull;

import java.util.List;

/**
 * Created by seymurmanafov on 2023. 05. 26..
 */
@Getter
@Setter
@ToString
public class DetectionDataRequest {

    @NotEmpty
    @JsonProperty(namespace = "base_station_id")
    private String baseStationId;
    @NotNull
    private List<MobileStationRequest> mobileStationRequestList;



    @Getter
    @Setter
    @ToString
    public static class MobileStationRequest {
        private String uuid;
        private double latitude;
        private double longitude;
    }
}
