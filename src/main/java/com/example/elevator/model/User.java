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
@Table(name="users")
public class User extends ElevatorEntity {

  /**
   * The identifier of the user.
   */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  @Getter
  @Setter
  private long id;

  /**
   * An int identifying the users current floor.
   */
  @Column(name="currentFloor")
  @Getter
  @Setter
  private int currentFloor;

  /**
   * An int identifying the users current building.
   */
  @Column(name="currentBuilding")
  @Getter
  @Setter
  private long currentBuilding;

  /**
   * A list of building identifiers accessible by the user instance.
   */
  @Column(name="buildingIdList")
  @Getter
  @Setter
  private String buildingIdList;

  public User(String name, String buildingIdList, int currentFloor, long currentBuilding) {
    this.setName(name);
    this.setBuildingIdList(buildingIdList);
    this.setCurrentFloor(currentFloor);
    this.setCurrentBuilding(currentBuilding);
  }
}
