package com.example.elevator.model;

import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

public class ElevatorTest {

  private Elevator elevator;

  @Test
  public void createElevator() {

    Elevator elevator1 = new Elevator("test1", 2, "1,2,3,4");
    Elevator elevator2 = new Elevator("test2", 3, "5,6,7,8");

    System.out.println(elevator1.getId());
    System.out.println(elevator2.getId());
  }

  @Test
  public void getElevatorStatus() {

    elevator = new Elevator("test3", 4, "9,10,11,12");
//    Assertions.assertThat(elevator.getElevatorStatus()).isEqualTo("STOPPED");
  }
}
