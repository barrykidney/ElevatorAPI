package com.example.elevator.service;

import com.example.elevator.model.Building;
import com.example.elevator.model.Elevator;
import com.example.elevator.repository.BuildingRepository;
import com.example.elevator.utils.converters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BuildingService {

  /**
   * Class level instance of BuildingRepository used for database persistence.
   */
  @Autowired
  private BuildingRepository buildingRepository;

  /**
   * Class level instance of ElevatorService.
   */
  @Autowired
  private ElevatorService elevatorService;

  /**
   * Persists Building entity in DB.
   */
  public Building createBuilding(Building building) {

    return buildingRepository.save(building);
  }

  /**
   * Retrieve all Building in DB.
   */
  public List<Building> getAllBuildings() {

    return buildingRepository.findAll();
  }

  public Building addElevatorToBuilding(int buildingId, int ElevatorId) {
    Building building = getBuildingById(buildingId);
    List<Integer> elevatorIdList = converters.convertStringToList(building.getElevatorIdList());
    elevatorIdList.add(ElevatorId);
    building.setElevatorIdList(converters.convertListToString(elevatorIdList));

    return buildingRepository.save(building);
  }

  /**
   * Retrieve Elevator by its Id.
   */
  public Building getBuildingById(long elevatorId) {
    Optional<Building> elevator = null;
    try {
      elevator = Optional
        .of(buildingRepository.findById(elevatorId).orElseThrow(IOException::new));
    } catch (IOException e) {
      e.printStackTrace();
    }

    return elevator.get();
  }

  public List<String> getStatusOfAllElevators(long buildingId) {
    Building building = getBuildingById(buildingId);
    List<Integer> elevatorList = converters.convertStringToList(building.getElevatorIdList());
    List<String> stateList = new ArrayList<>();

    for(int i = 0; i < elevatorList.size(); i++) {
      Elevator elevator = elevatorService.getElevatorById(elevatorList.get(i));
      stateList.add(elevator.getState().toString());
    }

    return stateList;
  }

  public List<Integer> getAllElevatorsInBuilding(long buildingId) {
    Building building = getBuildingById(buildingId);

    return converters.convertStringToList(building.getElevatorIdList());
  }
}
