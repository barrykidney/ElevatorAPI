package com.example.elevator.repository;

import com.example.elevator.model.Building;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BuildingRepository extends JpaRepository<Building, Long> {

}
