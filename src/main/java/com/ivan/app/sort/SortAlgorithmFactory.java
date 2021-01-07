package com.ivan.app.sort;

public abstract class SortAlgorithmFactory {

  public static enum SortType {
    MERGE_SORT,
    SELECTION_SORT
  }

  public static enum ImplementationType {
    C,
    CPP,
    JAVA
  }

  public static SortAlgorithm createInstance(
    SortType sortType, ImplementationType implementationType){

    if(implementationType.equals(ImplementationType.JAVA)){
      switch(sortType){
        case MERGE_SORT:
          return new MergeSortAlgorithmJavaImpl();
        case SELECTION_SORT:
          return new SelectionSortAlgorithmJavaImpl();
        default: 
          throw new RuntimeException("Sort type is unknown or not implemented !!!");
      }
    }

    if(implementationType.equals(ImplementationType.C)){
      switch(sortType){
        case MERGE_SORT:
          return new MergeSortAlgorithmCImpl();
        case SELECTION_SORT:
          return new SelectionSortAlgorithmCImpl();
        default: 
          throw new RuntimeException("Sort type is unknown or not implemented !!!");
      }
    }

    if(implementationType.equals(ImplementationType.CPP)){
      switch(sortType){
        case MERGE_SORT:
          return new MergeSortAlgorithmCppImpl();
        case SELECTION_SORT:
          return new SelectionSortAlgorithmCppImpl();
        default: 
          throw new RuntimeException("Sort type is unknown or not implemented !!!");
      }
    }
    
    throw new RuntimeException();
  }

}
