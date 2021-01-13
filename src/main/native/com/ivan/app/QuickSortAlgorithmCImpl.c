#include <stdlib.h>
#include "com_ivan_app_sort_QuickSortAlgorithmCImpl.h"

void quickSort(int *arr, int begin, int end);
int partition(int *arr, int begin, int end);
void swap(int *, int *);

JNIEXPORT void JNICALL Java_com_ivan_app_sort_QuickSortAlgorithmCImpl_sort
  (JNIEnv *env, jobject jObj, jintArray jArr, jint jSize)
{
  int size = (int)jSize;
  int *arr = (*env)->GetIntArrayElements(env, jArr, 0);

  quickSort(arr, 0, size - 1);

  (*env)->SetIntArrayRegion(env, jArr, 0, size, arr);
  (*env)->ReleaseIntArrayElements(env, jArr, arr, 0);
}

void quickSort(int *arr, int begin, int end)
{
  if (begin < end)
  {
    int p = partition(arr, begin, end);
    quickSort(arr, begin, p - 1);
    quickSort(arr, p + 1, end);
  }
}

int partition(int *arr, int begin, int end)
{
  int pivot = *(arr + end);
  int i = begin;

  for (int j = begin; j <= end; j++)
  {
    if (*(arr + j) < pivot)
    {
      swap(arr + i, arr + j);
      i++;
    }
  }

  swap(arr + i, arr + end);

  return i;
}

void swap(int *a, int *b)
{
  int temp = *a;
  *a = *b;
  *b = temp;
}