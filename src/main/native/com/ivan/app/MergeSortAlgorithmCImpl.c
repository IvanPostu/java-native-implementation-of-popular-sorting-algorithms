#include <stdlib.h>
#include "com_ivan_app_sort_MergeSortAlgorithmCImpl.h"

void mergeSort(int *arr, unsigned int size);
void merge(int *arr, int *left, int *right, unsigned int leftSize, unsigned int rightSize);

JNIEXPORT void JNICALL Java_com_ivan_app_sort_MergeSortAlgorithmCImpl_sort
  (JNIEnv *env, jobject jObj, jintArray jArr, jint jSize)
{
  unsigned int size = (unsigned int)jSize;
  int *arr = (*env)->GetIntArrayElements(env, jArr, 0);

  mergeSort(arr, size);

  (*env)->SetIntArrayRegion(env, jArr, 0, size, arr);
  (*env)->ReleaseIntArrayElements(env, jArr, arr, 0);
}

void mergeSort(int *arr, unsigned int size)
{
  if(size<2) return;

  unsigned int leftSize = size / 2;
  unsigned int rightSize = size - leftSize;
  int* left = (int*)malloc(sizeof(int) * leftSize);
  int* right = (int*)malloc(sizeof(int) * rightSize);

  for (unsigned int i = 0; i < leftSize; i++)
  {
    *(left + i) = *(arr + i);
  }
  
  for (unsigned int i = leftSize; i < size; i++)
  {
    *(right + i - leftSize) = *(arr + i);
  }

  
  mergeSort(left, leftSize);
  mergeSort(right, rightSize);

  merge(arr, left, right, leftSize, rightSize);
  
  free(left);
  free(right);
}

void merge(int *arr, int *left, int *right, unsigned int leftSize, unsigned int rightSize)
{
  unsigned int i=0, j=0, k=0;

  while(i<leftSize && j<rightSize)
  {
    if(*(left+i) <= *(right+j))
    {
      *(arr+k++) = *(left+i++);
    }
      else
    {
      *(arr+k++) = *(right+j++);
    }
  }

  while(i<leftSize)
  {
    *(arr+k++) = *(left+i++);
  }

  while(j<rightSize)
  {
    *(arr+k++) = *(right+j++);
  }

}