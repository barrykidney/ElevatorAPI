package com.example.elevator.utils;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class converters {

  public static List<Integer> convertStringToList(String floorList) {
    return Stream.of(floorList.split(","))
      .map(String::trim)
      .map(Integer::parseInt)
      .collect(Collectors.toList());
  }

  public static String convertListToString(List<Integer> floorList) {
    return floorList.stream().map(String::valueOf).collect(Collectors.joining(","));
  }
}
