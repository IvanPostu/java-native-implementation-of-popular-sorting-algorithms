package com.ivan.app.sort;

class QuickSortAlgorithmJavaImpl implements SortAlgorithm {

  private void quickSort(int[] arr, int begin, int end){
    if(begin < end){
      int p = partition(arr, begin, end);
      quickSort(arr, begin, p-1);
      quickSort(arr, p+1, end);
    }
  }

  private int partition(int []arr, int begin, int end){
    int pivot = arr[end];
    int i = begin;
    for (int j = begin; j <= end; j++) {
      if(arr[j] < pivot){
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
        i++;
      }
    }

    int temp = arr[i];
    arr[i] = arr[end];
    arr[end] = temp;
    
    return i;
  }

  @Override
  public void sort(int[] arr) {
    quickSort(arr, 0, arr.length-1);
  }

}
