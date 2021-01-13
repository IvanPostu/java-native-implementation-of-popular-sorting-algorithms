package com.ivan.app.sort;

import com.ivan.app.NativeLibUtils;

public class QuickSortAlgorithmCppImpl implements SortAlgorithm {

  static {
    NativeLibUtils.resolveLibrary("libQuickSortAlgorithmCppImpl_cpp.so");
  }
  
  private native void sort(int[] arr, int size);

  @Override
  public void sort(int[] arr) {
    sort(arr, arr.length);
  }

}
