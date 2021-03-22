package com.example.elevator.service;

import com.example.elevator.enums.ElevatorState;
import com.example.elevator.model.Building;
import com.example.elevator.model.Elevator;
import com.example.elevator.model.User;
import com.example.elevator.repository.UserRepository;
import com.example.elevator.utils.converters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

  /**
   * Class level instance of UserRepository used for database persistence.
   */
  @Autowired
  private UserRepository userRepository;

  /**
   * Class level instance of BuildingService.
   */
  @Autowired
  private BuildingService buildingService;

  /**
   * Class level instance of ElevatorService.
   */
  @Autowired
  private ElevatorService elevatorService;

  /**
   * Persists User entity in DB.
   */
  public User createUser(User user) {

    return userRepository.save(user);
  }

  /**
   * Retrieve all Users in DB.
   */
  public List<User> getAllUsers() {

    return userRepository.findAll();
  }

  /**
   * Retrieve User by its Id.
   */
  public User getUserById(long userId) {
    Optional<User> user = null;
    try {
      user = Optional
        .of(userRepository.findById(userId).orElseThrow(IOException::new));
    } catch (IOException e) {
      e.printStackTrace();
    }

    return user.get();
  }

  /**
   * Update User details in DB.
   */
  public User updateUser(long userId, User updatedUser) {
    User existingUser = getUserById(userId);
    existingUser.setName(updatedUser.getName());
    existingUser.setBuildingIdList(updatedUser.getBuildingIdList());

    return userRepository.save(existingUser);
  }

  /**
   * Find a building for a user.
   */
  public List<Integer> findBuildingForUser(long userId) {
    User user = getUserById(userId);

    return converters.convertStringToList(user.getBuildingIdList());
  }

  /**
   * Find an elevator for a user in the current building.
   */
  //TODO Method too big separate
  public Elevator summonElevatorForUser(long userId) {
    User user = getUserById(userId);
    int usersCurrentFloor =  user.getCurrentFloor();

    Integer closestDistance = Integer.MAX_VALUE;
    Integer closestElevatorId = null;
    
    Building building = buildingService.getBuildingById(user.getCurrentBuilding());
    List<Integer> elevatorList = converters.convertStringToList(building.getElevatorIdList());
    for(int i = 0; i < elevatorList.size(); i++) {
      Elevator elevator = elevatorService.getElevatorById(elevatorList.get(i));
      int currentFloor = elevator.getCurrentFloor();
      if (Math.abs(currentFloor - usersCurrentFloor) < closestDistance && elevator.getState() != ElevatorState.OUTOFSERVICE) {
        closestElevatorId = i;
      }
    }
    Elevator closestElevator = elevatorService.getElevatorById(closestElevatorId);
    if (closestElevator.getCurrentFloor() > usersCurrentFloor) {
      closestElevator.setState(ElevatorState.DOWN);
    } else if (closestElevator.getCurrentFloor() < usersCurrentFloor) {
      closestElevator.setState(ElevatorState.UP);
    } else {
      closestElevator.setState(ElevatorState.STOPPED);
    }
    return closestElevator;
  }
}
