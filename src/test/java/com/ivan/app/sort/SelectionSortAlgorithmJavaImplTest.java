package com.ivan.app.sort;

import java.util.stream.IntStream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SelectionSortAlgorithmJavaImplTest {

  @Test
  public void sortTest(){
    SortAlgorithm sortAlgorithm = new SelectionSortAlgorithmJavaImpl();
    int[] initialArr = {13, 22, 77, -10, -11, -90, 44};
    int[] sortedArr = IntStream
      .of(initialArr)
      .sorted()
      .toArray();
    
    sortAlgorithm.sort(initialArr);

    boolean arraysIsEquals = false;

    if(initialArr.length == sortedArr.length){
      for (int i = 0; i < sortedArr.length; i++) {
        if(initialArr[i]!=sortedArr[i]) throw new RuntimeException("Arrays is not equal!!!");
      }

      arraysIsEquals = true;
    }

    Assertions.assertTrue(arraysIsEquals);
  }
  
}
