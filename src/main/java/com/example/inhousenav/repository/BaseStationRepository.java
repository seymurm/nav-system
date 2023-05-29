package com.example.inhousenav.repository;

import com.example.inhousenav.model.dao.BaseStation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by seymurmanafov on 2023. 05. 26..
 */
@Repository
public interface BaseStationRepository extends JpaRepository<BaseStation, String> {
}
