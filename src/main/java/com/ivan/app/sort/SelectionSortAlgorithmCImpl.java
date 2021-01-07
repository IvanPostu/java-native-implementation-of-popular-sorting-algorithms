package com.ivan.app.sort;

import com.ivan.app.NativeLibUtils;

public class SelectionSortAlgorithmCImpl implements SortAlgorithm {
  
  static {
    NativeLibUtils.resolveLibrary("libSelectionSortAlgorithmCImpl_c.so");
  }

  private native void sort(int[] arr, int size);

  @Override
  public void sort(int[] arr) {
    sort(arr, arr.length);
  }

}
