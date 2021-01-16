#include <stdlib.h>
#include "com_ivan_app_sort_InsertionSortAlgorithmCImpl.h"

void insertionSort(int *arr, int size);

JNIEXPORT void JNICALL Java_com_ivan_app_sort_InsertionSortAlgorithmCImpl_sort
  (JNIEnv *env, jobject jObj, jintArray jArr, jint jSize)
{
  int size =  (int)jSize;
  int *arr = (*env)->GetIntArrayElements(env, jArr, 0);

  insertionSort(arr, size);

  (*env)->SetIntArrayRegion(env, jArr, 0, size, arr);
  (*env)->ReleaseIntArrayElements(env, jArr, arr, 0);
}

void insertionSort(int *arr, int size)
{
  int n = size;
  for (int j = 1; j < n; j++) {
    int key = *(arr+j);
    int i = j - 1;
    while ((i > -1) && (*(arr + i) > key)) {
      *(arr + i + 1) = *(arr + i);
      i--;
    }
    *(arr + i + 1) = key;
  }
}