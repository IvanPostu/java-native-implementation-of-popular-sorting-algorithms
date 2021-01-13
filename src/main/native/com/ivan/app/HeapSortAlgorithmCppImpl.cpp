#include <stdlib.h>
#include "com_ivan_app_sort_HeapSortAlgorithmCppImpl.h"

void heapify(int *arr, int size, int i);
void heapSort(int *arr, int size);

JNIEXPORT void JNICALL Java_com_ivan_app_sort_HeapSortAlgorithmCppImpl_sort(
  JNIEnv *env, jobject jObj, jintArray jArr, jint jSize)
{
  unsigned int size = (unsigned int)jSize;
  jboolean isCopy = (jboolean) true;
  int *arr = env->GetIntArrayElements(jArr, &isCopy);

  heapSort(arr, size);

  env->SetIntArrayRegion(jArr, 0, size, arr);
  env->ReleaseIntArrayElements(jArr, arr, 0);
}

void heapify(int *arr, int size, int i)
{
  int largest = i;
  int left = 2 * i + 1;
  int right = 2 * i + 2;

  if (left < size && arr[left] > arr[largest])
    largest = left;

  if (right < size && arr[right] > arr[largest])
    largest = right;

  if (largest != i)
  {
    int temp = arr[i];
    arr[i] = arr[largest];
    arr[largest] = temp;
    heapify(arr, size, largest);
  }
}

void heapSort(int *arr, int size)
{
  int i;
  for (i = size / 2 - 1; i >= 0; i--)
    heapify(arr, size, i);
  for (i = size - 1; i >= 0; i--)
  {
    int temp = arr[0];
    arr[0] = arr[i];
    arr[i] = temp;
    heapify(arr, i, 0);
  }
}