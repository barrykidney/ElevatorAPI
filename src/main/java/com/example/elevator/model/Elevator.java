package com.example.elevator.model;

import com.example.elevator.enums.ElevatorState;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="elevators")
public class Elevator extends ElevatorEntity {

  /**
   * The identifier of the elevator.
   */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  @Getter
  private long id;

  /**
   * The current state of the elevator.
   */
  @Column(name="state")
  @Enumerated(EnumType.ORDINAL)
  @Getter
  @Setter
  private ElevatorState state;

  /**
   * The floor the elevator is currently at.
   */
  @Column(name="floor")
  @Getter
  @Setter
  private int currentFloor;

  /**
   * A list of floors accessible to the elevator in String format.
   */
  @Column(name="floorlist")
  @Getter
  @Setter
  private String floorList;

  public Elevator(String name, int currentFloor, String floorList) {
    this.setState(ElevatorState.STOPPED);
    this.setName(name);
    System.out.println(floorList);
    this.setFloorList(floorList);
    this.setCurrentFloor(currentFloor);
    //TODO check that currentFloor is contained in floorList.
  }

  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("id: " + this.getId());
    sb.append("name: " + this.getName());
    sb.append("state: " + this.getState());
    sb.append("current floor: " + this.getCurrentFloor());
    sb.append("list of floors: " + this.getFloorList());
    return sb.toString();
  }
}
