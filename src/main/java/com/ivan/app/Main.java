package com.ivan.app;

import java.io.IOException;
import java.net.URISyntaxException;

import com.ivan.app.configuration.Log4jConfiguration;
import com.ivan.app.sort.SortAlgorithm;
import com.ivan.app.sort.SortAlgorithmFactory;
import com.ivan.app.sort.SortAlgorithmFactory.ImplementationType;
import com.ivan.app.sort.SortAlgorithmFactory.SortType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
  static {
    Log4jConfiguration.configure();
  }

  private static final Logger logger = LogManager.getLogger(Main.class);

  public static void main(String[] args) throws IOException, URISyntaxException {

    logger.info("example1");
    logger.error("example2");
    
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
