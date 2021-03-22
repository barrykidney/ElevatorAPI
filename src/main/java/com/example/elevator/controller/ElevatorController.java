package com.example.elevator.controller;

import com.example.elevator.model.Elevator;
import com.example.elevator.service.ElevatorService;
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
@RequestMapping("elevators")
public class ElevatorController {

  /**
   * Autowired instance of a ElevatorService to run the business logic.
   */
  @Autowired
  private ElevatorService elevatorService;

  /**
   * REST endpoint to create a new elevator.
   *
   * @return created Elevator.
   */
  @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
  @ResponseStatus(HttpStatus.OK)
  public List<Elevator> getAllElevators() {
;
    return elevatorService.getAllElevators();
  }

  /**
   * REST endpoint to create a new elevator.
   *
   * @return created Elevator.
   */
  @GetMapping(path = "/{elevatorId}", produces = {MediaType.APPLICATION_JSON_VALUE})
  @ResponseStatus(HttpStatus.OK)
  public Elevator getElevatorById(@PathVariable("elevatorId") final long elevatorId) {

    return elevatorService.getElevatorById(elevatorId);
  }

  /**
   * REST endpoint to create a new elevator.
   *
   * @param elevator to create from.
   * @return created Elevator.
   */
  @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE},
    produces = {MediaType.APPLICATION_JSON_VALUE})
  @ResponseStatus(HttpStatus.CREATED)
  public Elevator createElevator(@RequestBody Elevator elevator) {

    return elevatorService.createElevator(elevator);
  }
}
