#include <stdlib.h>
#include "com_ivan_app_sort_InsertionSortAlgorithmCppImpl.h"

void insertionSort(int *arr, int size);

JNIEXPORT void JNICALL Java_com_ivan_app_sort_InsertionSortAlgorithmCppImpl_sort(
  JNIEnv *env, jobject jObj, jintArray jArr, jint jSize)
{
  unsigned int size = (unsigned int)jSize;
  jboolean isCopy = (jboolean) true;
  int *arr = env->GetIntArrayElements(jArr, &isCopy);

  insertionSort(arr, size);

  env->SetIntArrayRegion(jArr, 0, size, arr);
  env->ReleaseIntArrayElements(jArr, arr, 0);
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