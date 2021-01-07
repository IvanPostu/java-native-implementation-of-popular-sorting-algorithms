package com.ivan.app.sort;

import com.ivan.app.NativeLibUtils;

public class SortCppNativeImpl implements Sort {

  static {
    NativeLibUtils.resolveLibrary("libSortCppNativeImpl_cpp.so");
  }

  private native void selectionSort(int[] arr, int size);

  @Override
  public void sort(int[] arr, int size, SortType sortType) {
    if(SortType.INSERTION.equals(sortType)){
      selectionSort(arr, size);
    }
  }
  
}
