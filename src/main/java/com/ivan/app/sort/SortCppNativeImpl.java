// package com.ivan.app.sort;

// import com.ivan.app.NativeLibUtils;

// public class SortCppNativeImpl implements SortAlgorithm {

//   static {
//     NativeLibUtils.resolveLibrary("libSortCppNativeImpl_cpp.so");
//   }

//   private native void selectionSort(int[] arr, int size);

//   private native void mergeSort(int[] arr, int size);

//   @Override
//   public void sort(int[] arr, int size, SortType sortType) {
//     if(SortType.INSERTION.equals(sortType)){
//       selectionSort(arr, size);
//     }

//     if(SortType.MERGE.equals(sortType)){
//       mergeSort(arr, size);
//     }
//   }
  
// }
