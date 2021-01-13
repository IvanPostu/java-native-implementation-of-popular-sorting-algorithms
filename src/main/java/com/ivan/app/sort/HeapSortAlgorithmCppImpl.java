package com.ivan.app.sort;

import com.ivan.app.NativeLibUtils;

public class HeapSortAlgorithmCppImpl implements SortAlgorithm {

  static {
    NativeLibUtils.resolveLibrary("libHeapSortAlgorithmCppImpl_cpp.so");
  }
  
  private native void sort(int[] arr, int size);

  @Override
  public void sort(int[] arr) {
    sort(arr, arr.length);
  }

}
