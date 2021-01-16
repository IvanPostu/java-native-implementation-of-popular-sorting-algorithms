package com.ivan.app.sort;

import com.ivan.app.NativeLibUtils;

class InsertionSortAlgorithmCppImpl implements SortAlgorithm {

  static {
    NativeLibUtils.resolveLibrary("libInsertionSortAlgorithmCppImpl_cpp.so");
  }
  
  private native void sort(int[] arr, int size);

  @Override
  public void sort(int[] arr) {
    sort(arr, arr.length);
  }

}
