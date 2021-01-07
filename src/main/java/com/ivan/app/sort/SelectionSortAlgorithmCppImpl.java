package com.ivan.app.sort;

import com.ivan.app.NativeLibUtils;

public class SelectionSortAlgorithmCppImpl implements SortAlgorithm {
  
  static {
    NativeLibUtils.resolveLibrary("libSelectionSortAlgorithmCppImpl_cpp.so");
  }

  private native void sort(int[] arr, int size);

  @Override
  public void sort(int[] arr) {
    sort(arr, arr.length);
  }

}
