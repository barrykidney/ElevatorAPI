package com.example.elevator.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="buildings")
public class Building extends ElevatorEntity {

  /**
   * The identifier of the building.
   */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  @Getter
  @Setter
  private long id;

  //TODO make location its own class
  /**
   * The location of the building.
   */
  @Column(name="location")
  @Getter
  @Setter
  private String location;

  /**
   * A list of Elevator identifiers owned by the building instance.
   */
  @Column(name="elevatorIdList")
  @Getter
  @Setter
  private String elevatorIdList;

  public Building(String name, String location, String elevatorIdList) {
    this.setName(name);
    this.setLocation(location);
    //TODO check that each elevator in the elevator exists and is not owned by another building.
    this.setElevatorIdList(elevatorIdList);
  }
}
