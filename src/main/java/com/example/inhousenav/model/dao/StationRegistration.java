package com.example.inhousenav.model.dao;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

/**
 * Created by seymurmanafov on 2023. 05. 29..
 */
@Getter
@Setter

@Entity
@Table
public class StationRegistration {

    @EmbeddedId
    StationRegistrationKey id;

    @ManyToOne
    @MapsId("baseId")
    @JoinColumn(name = "base_id")
    BaseStation baseStation;

    @ManyToOne
    @MapsId("mobileId")
    @JoinColumn(name = "mobile_id")
    MobileStation mobileStation;

    @Column
    Long distance;

    @CreationTimestamp
    LocalDateTime created;

}
