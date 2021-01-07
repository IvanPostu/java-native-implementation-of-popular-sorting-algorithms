package com.ivan.app;

import java.io.IOException;
import java.net.URISyntaxException;

import com.ivan.app.sort.SortCppNativeImpl;
import com.ivan.app.sort.SortType;

public class Main {

  public static void main(String[] args) throws IOException, URISyntaxException {
    int []arr = {2, 22, 31, 90, 11, 4, 3, 91, 77, 32, 0, -10, -20, 30, 197, 3};

    System.out.println("Unsorted array: ");
    for(int a : arr){
      System.out.print(String.format("%d ", a));
    }
    System.out.println();    
    
    new SortCppNativeImpl().sort(arr, arr.length, SortType.INSERTION);
    
    System.out.println("Sorted array: ");
    for(int a : arr){
      System.out.print(String.format("%d ", a));
    }
    System.out.println();
  }

}
