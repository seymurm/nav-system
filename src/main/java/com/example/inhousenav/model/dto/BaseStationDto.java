package com.example.inhousenav.model.dto;

import com.example.inhousenav.model.dao.BaseStation;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by seymurmanafov on 2023. 05. 26..
 */
@Getter
@Setter
@Builder
@ToString
public class BaseStationDto {
    private String id;
    private String name;
    private double latitude;
    private double longitude;
    private double detectionRadiusInMeters;

    public BaseStation toDao() {
        return BaseStation.builder()
            .uuid(id)
            .name(name)
            .detectionRadiusInMeters(detectionRadiusInMeters)
            .latitude(latitude)
            .longitude(longitude)
            .build();
    }
}
