// package com.ivan.app.sort;

// import com.ivan.app.NativeLibUtils;

// public class SortCNativeImpl implements SortAlgorithm {

//   static {
//     NativeLibUtils.resolveLibrary("libSortCNativeImpl_c.so");
//   }

//   private native void selectionSort(int[] arr, int size);

//   private native void mergeSort(int[] arr, int size);

//   @Override
//   public void sort(int[] arr, int size, SortType sortType) {

//     if (SortType.INSERTION.equals(sortType)) {
//       selectionSort(arr, size);
//     }
//     if (SortType.MERGE.equals(sortType)) {
//       selectionSort(arr, size);
//     }
//   }

// }
