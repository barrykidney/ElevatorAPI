package com.example.elevator.controller;

import com.example.elevator.model.Elevator;
import com.example.elevator.model.User;
import com.example.elevator.service.UserService;
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
@RequestMapping("users")
public class UserController {

  /**
   * Autowired instance of a UserService to run the business logic.
   */
  @Autowired
  private UserService userService;

  /**
   * REST endpoint to create a new elevator.
   *
   * @return created Elevator.
   */
  @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
  @ResponseStatus(HttpStatus.OK)
  public List<User> getAllUsers() {

    return userService.getAllUsers();
  }

  /**
   * REST endpoint to create a new elevator.
   *
   * @return created Elevator.
   */
  @GetMapping(path = "/{userId}", produces = {MediaType.APPLICATION_JSON_VALUE})
  @ResponseStatus(HttpStatus.OK)
  public User getUserById(@PathVariable("userId") final long userId) {

    return userService.getUserById(userId);
  }

  /**
   * REST endpoint to create a new elevator.
   *
   * @param user to create from.
   * @return created User.
   */
  @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE},
    produces = {MediaType.APPLICATION_JSON_VALUE})
  @ResponseStatus(HttpStatus.CREATED)
  public User createUser(@RequestBody User user) {

    return userService.createUser(user);
  }

  /**
   * REST endpoint to create a new elevator.
   *
   * @return created Elevator.
   */
  @GetMapping(path = "/{userId}",
    consumes = {MediaType.APPLICATION_JSON_VALUE},
    produces = {MediaType.APPLICATION_JSON_VALUE})
  @ResponseStatus(HttpStatus.OK)
  public User updateUser(@PathVariable("userId") final long userId, @RequestBody User user) {

    return userService.updateUser(userId, user);
  }

  /**
   * REST endpoint to find a building for a user.
   *
   * @return list of buildings.
   */
  @GetMapping(path = "/{userId}",
    produces = {MediaType.APPLICATION_JSON_VALUE})
  @ResponseStatus(HttpStatus.OK)
  public List<Integer> findBuildingForUser(@PathVariable("userId") final long userId) {

    return userService.findBuildingForUser(userId);
  }

  /**
   * REST endpoint to summon an elevator for a user.
   *
   * @return Elevator.
   */
  @GetMapping(path = "/{userId}",
    produces = {MediaType.APPLICATION_JSON_VALUE})
  @ResponseStatus(HttpStatus.OK)
  public Elevator summonElevatorForUser(@PathVariable("userId") final long userId) {

    return userService.summonElevatorForUser(userId);
  }

}
