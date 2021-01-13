package com.ivan.app.sort;

import java.util.stream.IntStream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer.MethodName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodName.class)
public class QuickSortAlgorithmCppImplTest {
  
  @Test
  public void sortTest(){
    SortAlgorithm sortAlgorithm = new QuickSortAlgorithmCppImpl();
    int[] initialArr = {13, 22, 77, -10, -11, -90, 44};
    int[] sortedArr = IntStream
      .of(initialArr)
      .sorted()
      .toArray();
    
    sortAlgorithm.sort(initialArr);
    Assertions.assertArrayEquals(initialArr, sortedArr);
  }

}
