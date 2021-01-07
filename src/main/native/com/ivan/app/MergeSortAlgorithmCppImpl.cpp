#include <stdlib.h>
#include "com_ivan_app_sort_MergeSortAlgorithmCppImpl.h"

class MergeSort {
public:
  void sort(int *arr, size_t size);
private: 
  void merge(int *arr, int *leftArr, int *rightArr, size_t leftSize, size_t rightSize);
};


JNIEXPORT void JNICALL Java_com_ivan_app_sort_MergeSortAlgorithmCppImpl_sort
  (JNIEnv *env, jobject jObj, jintArray jArr, jint jSize)
{
  unsigned int size = (unsigned int)jSize;
  jboolean isCopy = (jboolean)true;
  int *arr = env->GetIntArrayElements(jArr, &isCopy);
  
  MergeSort *sort = new MergeSort;
  sort->sort(arr, size);
  delete sort;

  env->SetIntArrayRegion( jArr, 0, size, arr);
  env->ReleaseIntArrayElements( jArr, arr, 0);
}


void MergeSort::sort(int *arr, size_t size)
{
  if(size<2) return;

  size_t leftSize = size / 2;
  size_t rightSize = size - leftSize;

  int *left = new int[leftSize];
  int *right = new int[rightSize];

  for (size_t i = 0; i < leftSize; i++)
  {
    *(left + i) = *(arr + i);
  }

  for (size_t i = leftSize; i < size; i++)
  {
    *(right + i - leftSize) = *(arr + i);
  }
  
  this->sort(left, leftSize);
  this->sort(right, rightSize);
  
  this->merge(arr, left, right, leftSize, rightSize);

  delete[] left;
  delete[] right;
}

void MergeSort::merge(int *arr, int *leftArr, int *rightArr, size_t leftSize, size_t rightSize)
{
  size_t i, j, k;

  for(i=0, j=0, k=0; i<leftSize && j<rightSize; )
  {
    if(*(leftArr+i) <= *(rightArr+j))
    {
      *(arr + k++) = *(leftArr+i++);
    }
    else
    {
      *(arr + k++) = *(rightArr+j++);
    }
  }

  for(i; i<leftSize;)
  {
    *(arr + k++) = *(leftArr+i++);
  }

  for(j; j<rightSize;)
  {
    *(arr + k++) = *(rightArr+j++);
  }

}