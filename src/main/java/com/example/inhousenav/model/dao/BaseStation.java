package com.example.inhousenav.model.dao;

import com.example.inhousenav.model.dto.BaseStationDto;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

import static jakarta.persistence.GenerationType.UUID;

/**
 * Created by seymurmanafov on 2023. 05. 26..
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor

@Table
@Entity
public class BaseStation {
    @Id
    @GeneratedValue(strategy = UUID)
    private String uuid;
    private String name;
    private double latitude;
    private double longitude;
    private double detectionRadiusInMeters;

    @OneToMany(mappedBy = "baseStation")
    private Set<StationRegistration> registrations = new HashSet<>();

//    @ManyToMany
//    @JoinTable(
//        name = "base_mobile_stations",
//        joinColumns = @JoinColumn(name = "base_station_id"),
//        inverseJoinColumns = @JoinColumn(name = "mobile_station_id"))
//    Set<MobileStation> mobileStations;

    public BaseStationDto toDto() {
        return BaseStationDto.builder()
            .id(uuid)
            .name(name)
            .latitude(latitude)
            .longitude(longitude)
            .build();
    }
}
