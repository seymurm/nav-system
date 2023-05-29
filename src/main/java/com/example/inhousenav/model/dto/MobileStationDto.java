package com.example.inhousenav.model.dto;

import com.example.inhousenav.model.dao.MobileStation;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by seymurmanafov on 2023. 05. 26..
 */
@Getter
@Setter
@ToString
public class MobileStationDto {
    private String uuid;
    private double lastKnownX;
    private double lastKnownY;

    public MobileStation toDao() {
        return MobileStation.builder()
            .uuid(uuid)
            .lastKnownX(lastKnownX)
            .lastKnownY(lastKnownY)
            .build();
    }
}
