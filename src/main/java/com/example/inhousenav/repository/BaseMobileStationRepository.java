package com.example.inhousenav.repository;

import com.example.inhousenav.model.dao.MobileStation;
import com.example.inhousenav.model.dao.StationRegistrationKey;
import com.example.inhousenav.model.dao.StationRegistration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Created by seymurmanafov on 2023. 05. 29..
 */
@Repository
public interface BaseMobileStationRepository extends JpaRepository<StationRegistration, StationRegistrationKey> {

    Optional<StationRegistration> findLastByMobileStationOrderByCreatedDesc(MobileStation mobileStation);
}
