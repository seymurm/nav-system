package com.example.inhousenav.model.dao;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class MobileStation {
    @Id
    @GeneratedValue(strategy = UUID)
    private String uuid;
    private double lastKnownX;
    private double lastKnownY;

    @JsonIgnore
    @OneToMany(mappedBy = "mobileStation")
    private Set<StationRegistration> registrations = new HashSet<>();
}
