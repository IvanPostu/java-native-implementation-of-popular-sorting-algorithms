package com.ivan.app.sort;

import com.ivan.app.NativeLibUtils;

public class BubbleSortAlgorithmCImpl implements SortAlgorithm {

  static {
    NativeLibUtils.resolveLibrary("libBubbleSortAlgorithmCImpl_c.so");
  }

  private native void bubbleSort(int[] arr, int size);

  @Override
  public void sort(int[] arr) {
    bubbleSort(arr, arr.length);
  }

}
