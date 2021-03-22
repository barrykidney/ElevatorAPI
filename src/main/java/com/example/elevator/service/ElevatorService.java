package com.example.elevator.service;

import com.example.elevator.model.Elevator;
import com.example.elevator.repository.ElevatorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;


@Service
public class ElevatorService {

  /**
   * Class level instance of ElevatorRepository used for database persistence.
   */
  @Autowired
  private ElevatorRepository elevatorRepository;

  /**
   * Persists Elevator entity in DB.
   */
  public Elevator createElevator(Elevator elevator) {

    return elevatorRepository.save(elevator);
  }

  /**
   * Retrieve all Elevators in DB.
   */
  public List<Elevator> getAllElevators() {

    return elevatorRepository.findAll();
  }

  /**
   * Retrieve Elevator by its Id.
   */
  public Elevator getElevatorById(long elevatorId) {
    Optional<Elevator> elevator = null;
    try {
      elevator = Optional
        .of(elevatorRepository.findById(elevatorId).orElseThrow(IOException::new));
    } catch (IOException e) {
      e.printStackTrace();
    }

    return elevator.get();
  }
}
