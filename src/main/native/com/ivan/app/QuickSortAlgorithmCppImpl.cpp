#include <stdlib.h>
#include "com_ivan_app_sort_QuickSortAlgorithmCppImpl.h"

class QuickSort {
public:
  void quickSort(int *arr, int begin, int end);
private:
  int partition(int *arr, int begin, int end);
  void swap(int *, int *);  
};

JNIEXPORT void JNICALL Java_com_ivan_app_sort_QuickSortAlgorithmCppImpl_sort(
  JNIEnv *env, jobject jObj, jintArray jArr, jint jSize)
{
  unsigned int size = (unsigned int)jSize;
  jboolean isCopy = (jboolean) true;
  int *arr = env->GetIntArrayElements(jArr, &isCopy);

  QuickSort *quickSort = new QuickSort();
  quickSort->quickSort(arr, 0, (int)size-1);
  delete quickSort;

  env->SetIntArrayRegion(jArr, 0, size, arr);
  env->ReleaseIntArrayElements(jArr, arr, 0);
}


void QuickSort::quickSort(int *arr, int begin, int end)
{
  if (begin < end)
  {
    int p = partition(arr, begin, end);
    this->quickSort(arr, begin, p - 1);
    this->quickSort(arr, p + 1, end);
  }
}

int QuickSort::partition(int *arr, int begin, int end)
{
  int pivot = *(arr + end);
  int i = begin;

  for (int j = begin; j <= end; j++)
  {
    if (*(arr + j) < pivot)
    {
      this->swap(arr + i, arr + j);
      i++;
    }
  }

  this->swap(arr + i, arr + end);

  return i;
}

void QuickSort::swap(int *a, int *b)
{
  int temp = *a;
  *a = *b;
  *b = temp;
}
