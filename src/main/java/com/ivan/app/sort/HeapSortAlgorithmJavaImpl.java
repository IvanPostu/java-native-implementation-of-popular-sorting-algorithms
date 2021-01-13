package com.ivan.app.sort;

import java.util.Arrays;

class HeapSortAlgorithmJavaImpl implements SortAlgorithm {

  void heapify(int[] arr, int size, int i) {
    int largest = i;
    int left = 2 * i + 1;
    int right = 2 * i + 2;

    if (left < size && arr[left] > arr[largest])
      largest = left;

    if (right < size && arr[right] > arr[largest])
      largest = right;

    if (largest != i) {
      int temp = arr[i];
      arr[i] = arr[largest];
      arr[largest] = temp;
      heapify(arr, size, largest);
    }
  }

  void heapSort(int[] arr, int size) {
    int i;
    for (i = size / 2 - 1; i >= 0; i--)
      heapify(arr, size, i);
    for (i = size - 1; i >= 0; i--) {
      int temp = arr[0];
      arr[0] = arr[i];
      arr[i] = temp;
      heapify(arr, i, 0);
    }
  }

  @Override
  public void sort(int[] arr) {
    heapSort(arr, arr.length);
  }

  public static void main(String[] args) {
    HeapSortAlgorithmJavaImpl instance = new HeapSortAlgorithmJavaImpl();

    int[] arr = { 6, 5, 3, 1, 8, 7, 2, 4 };
    instance.sort(arr);

    int[] expectedArr = Arrays.copyOf(arr, arr.length);
    Arrays.sort(expectedArr);

    int count = 0;
    for (int i = 0; i < expectedArr.length; i++) {
      if (expectedArr[i] != arr[i])
        count++;
    }

    System.out.println(count);

  }

}
