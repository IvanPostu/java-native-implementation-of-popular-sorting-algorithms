package com.ivan.app.sort;

class SelectionSortAlgorithmJavaImpl implements SortAlgorithm {
  
  private void selectionSort(int[] arr, int size){
    int tempIndex;
    for(int i=0; i<size-1; i++){
      tempIndex = i;
      for (int j = i+1; j < size; j++) {
        if(arr[tempIndex] > arr[j]){
          tempIndex = j;
        }
      }

      int z = arr[tempIndex];
      arr[tempIndex] = arr[i];
      arr[i] = z;
    }
  }

  @Override
  public void sort(int[] arr) {
    selectionSort(arr, arr.length);
  }

}
