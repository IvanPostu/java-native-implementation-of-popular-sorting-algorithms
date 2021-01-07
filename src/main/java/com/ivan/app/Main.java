package com.ivan.app;

import java.io.IOException;
import java.net.URISyntaxException;

import com.ivan.app.sort.SortAlgorithm;
import com.ivan.app.sort.SortAlgorithmFactory;
import com.ivan.app.sort.SortAlgorithmFactory.ImplementationType;
import com.ivan.app.sort.SortAlgorithmFactory.SortType;

public class Main {

  public static void main(String[] args) throws IOException, URISyntaxException {
    int []arr = {2, 22, 31, 90, 11, 4, 3, 91, 77, 32, 0, -10, -20, 30, 197, 3};

    System.out.println("Unsorted array: ");
    for(int a : arr){
      System.out.print(String.format("%d ", a));
    }
    System.out.println();    
    
    SortAlgorithm sortAlgorithm = SortAlgorithmFactory
      .createInstance(SortType.SELECTION_SORT, ImplementationType.C);

    sortAlgorithm.sort(arr);
    
    System.out.println("Sorted array: ");
    for(int a : arr){
      System.out.print(String.format("%d ", a));
    }
    System.out.println();
  }

}
