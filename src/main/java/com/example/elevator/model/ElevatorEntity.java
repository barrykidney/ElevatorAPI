package com.example.elevator.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;


abstract class ElevatorEntity {

  /**
   * The name of the building.
   */
  @Column(name="name")
  @Getter
  @Setter
  private String name;
}
