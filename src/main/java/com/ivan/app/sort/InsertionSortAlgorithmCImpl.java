package com.ivan.app.sort;

import com.ivan.app.NativeLibUtils;

class InsertionSortAlgorithmCImpl implements SortAlgorithm {

  static {
    NativeLibUtils.resolveLibrary("libInsertionSortAlgorithmCImpl_c.so");
  }
  
  private native void sort(int[] arr, int size);

  @Override
  public void sort(int[] arr) {
    sort(arr, arr.length);
  }

}
