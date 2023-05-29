package com.example.inhousenav.repository;

import com.example.inhousenav.model.dao.MobileStation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by seymurmanafov on 2023. 05. 26..
 */
@Repository
public interface MobileStationRepository extends JpaRepository<MobileStation, String> {
}
