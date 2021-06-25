package com.example.sitecore.repository;

import com.example.sitecore.domain.dto.Route;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RouteRepository extends JpaRepository<Route, Integer> {

    @Query(value = "SELECT DEPARTURE_CODE, ARRIVAL_CODE FROM ROUTE", nativeQuery = true)
    public List<String> findAllCodes();

    Route findById(int id);
}
