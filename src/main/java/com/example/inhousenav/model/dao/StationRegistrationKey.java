package com.example.inhousenav.model.dao;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;

/**
 * Created by seymurmanafov on 2023. 05. 29..
 */
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor

@Embeddable
public class StationRegistrationKey implements Serializable {

    @Column(name = "mobile_id")
    private String mobileStationId;

    @Column(name = "base_id")
    private String baseStationId;

}
