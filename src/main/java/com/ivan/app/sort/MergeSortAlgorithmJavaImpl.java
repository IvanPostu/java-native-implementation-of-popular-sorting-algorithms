package com.ivan.app.sort;

class MergeSortAlgorithmJavaImpl implements SortAlgorithm {
  
  private void mergeSort(int[] arr, int size){
    if(size<2) return;

    int middle = size / 2;
    int[] left = new int[middle];
    int[] right = new int[size - middle];

    for (int i = 0; i < middle; i++) {
      left[i] = arr[i];
    }

    for (int i = middle; i < size; i++) {
      right[i - middle] = arr[i];
    }

    mergeSort(left, middle);
    mergeSort(right, size - middle);

    merge(arr, left, right);
  }

  private void merge(int[]arr, int[] left, int[] right){

    int i, j, k;
    for( i=0, j=0, k=0; i<left.length && j<right.length; ){
      if(left[i] <= right[j]){
        arr[k++] = left[i++];
      }else{
        arr[k++] = right[j++];
      }
    }

    while(i<left.length){
      arr[k++] = left[i++];
    }

    while(j<right.length){
      arr[k++] = right[j++];
    }
  }

  @Override
  public void sort(int[] arr) {
    mergeSort(arr, arr.length);
  }
}
