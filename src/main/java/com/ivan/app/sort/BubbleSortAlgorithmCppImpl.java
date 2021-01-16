package com.ivan.app.sort;

import com.ivan.app.NativeLibUtils;

public class BubbleSortAlgorithmCppImpl implements SortAlgorithm {

  static {
    NativeLibUtils.resolveLibrary("libBubbleSortAlgorithmCppImpl_cpp.so");
  }
  
  private native void bubbleSort(int[] arr, int size);

  @Override
  public void sort(int[] arr) {
    bubbleSort(arr, arr.length);
  }

}
