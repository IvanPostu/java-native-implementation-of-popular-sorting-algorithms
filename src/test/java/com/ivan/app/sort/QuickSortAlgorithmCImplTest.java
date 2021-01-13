package com.ivan.app.sort;

import java.util.stream.IntStream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class QuickSortAlgorithmCImplTest {
  
  @Test
  public void sortTest(){
    SortAlgorithm sortAlgorithm = new QuickSortAlgorithmCImpl();
    int[] initialArr = {13, 22, 77, -10, -11, -90, 44};
    int[] sortedArr = IntStream
      .of(initialArr)
      .sorted()
      .toArray();
    
    sortAlgorithm.sort(initialArr);
    Assertions.assertArrayEquals(initialArr, sortedArr);
  }

}
