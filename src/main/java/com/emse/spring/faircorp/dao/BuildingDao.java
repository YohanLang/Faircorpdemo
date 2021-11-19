package com.emse.spring.faircorp.dao;
import com.emse.spring.faircorp.model.Building;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BuildingDao extends JpaRepository<Building, Long> {
    @Query("select r from Building r where r.name=:name")
    List<Building> findByName(@Param("name") String name);
}