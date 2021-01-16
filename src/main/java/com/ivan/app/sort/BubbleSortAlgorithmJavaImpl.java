package com.ivan.app.sort;

class BubbleSortAlgorithmJavaImpl implements SortAlgorithm {

  private void bubbleSort(int[] array) {
    if(array == null || array.length <= 1 )return;
    boolean isSorted = false;

    while(!isSorted){
      isSorted = true;
      for (int i = 1; i < array.length; i++) {
        if(array[i-1] > array[i]){
          int temp = array[i-1];
          array[i-1] = array[i];
          array[i] = temp;
          isSorted = false;
        }
      }
    }
  }

  @Override
  public void sort(int[] arr) {
    bubbleSort(arr);
  }

}
