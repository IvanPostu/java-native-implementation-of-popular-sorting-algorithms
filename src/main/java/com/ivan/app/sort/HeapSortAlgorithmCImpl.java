package com.ivan.app.sort;

import com.ivan.app.NativeLibUtils;

public class HeapSortAlgorithmCImpl implements SortAlgorithm {

  static {
    NativeLibUtils.resolveLibrary("libHeapSortAlgorithmCImpl_c.so");
  }

  private native void sort(int[] arr, int size);

  @Override
  public void sort(int[] arr) {
    sort(arr, arr.length);
  }

}
