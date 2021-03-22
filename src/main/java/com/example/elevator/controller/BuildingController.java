package com.example.elevator.controller;

import com.example.elevator.model.Building;
import com.example.elevator.model.Elevator;
import com.example.elevator.service.BuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("buildings")
public class BuildingController {

  /**
   * Autowired instance of a BuildingService to run the business logic.
   */
  @Autowired
  private BuildingService buildingService;

  /**
   * REST endpoint to create a new building.
   *
   * @return created Building.
   */
  @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
  @ResponseStatus(HttpStatus.OK)
  public List<Building> getAllBuildings() {
    ;
    return buildingService.getAllBuildings();
  }

  /**
   * REST endpoint to create a new elevator.
   *
   * @return created Building.
   */
  @GetMapping(path = "/{buildingId}", produces = {MediaType.APPLICATION_JSON_VALUE})
  @ResponseStatus(HttpStatus.OK)
  public Building getBuildingById(@PathVariable("buildingId") final long buildingId) {

    return buildingService.getBuildingById(buildingId);
  }

  /**
   * REST endpoint to create a new building.
   *
   * @param building to create from.
   * @return created Building.
   */
  @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE},
    produces = {MediaType.APPLICATION_JSON_VALUE})
  @ResponseStatus(HttpStatus.CREATED)
  public Building createBuilding(@RequestBody Building building) {

    return buildingService.createBuilding(building);
  }

  /**
   * REST endpoint to get the state of all elevators in a building.
   *
   * @param buildingId to to get data for.
   * @return list of elevator states.
   */
  @PostMapping(path = "/{buildingId}",
    produces = {MediaType.APPLICATION_JSON_VALUE})
  @ResponseStatus(HttpStatus.OK)
  public List<String> getStatusOfAllElevatorsInBuilding(@PathVariable("buildingId") final long buildingId) {

    return buildingService.getStatusOfAllElevators(buildingId);
  }
}
