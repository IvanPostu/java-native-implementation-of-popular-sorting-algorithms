#include <stdlib.h>
#include "com_ivan_app_sort_SelectionSortAlgorithmCImpl.h"

void swap(int *a, int *b);
void selectionSort(int *arr, unsigned int size);

JNIEXPORT void JNICALL Java_com_ivan_app_sort_SelectionSortAlgorithmCImpl_sort
  (JNIEnv *env, jobject jObj, jintArray jArr, jint jSize)
{
  unsigned int size = (unsigned int)jSize;
  int *arr = (*env)->GetIntArrayElements(env, jArr, 0);

  selectionSort(arr, size);

  (*env)->SetIntArrayRegion(env, jArr, 0, size, arr);
  (*env)->ReleaseIntArrayElements(env, jArr, arr, 0);
}

void swap(int *a, int *b)
{
  int c = *a;
  *a = *b;
  *b = c;
}

void selectionSort(int *arr, unsigned int size)
{
  unsigned int temp;
  unsigned int i, j;

  for(i=0; i<size; i++)
  {
    temp=i;
    for(j=i; j<size; j++)
    {
      if(*(arr + temp) > *(arr+j))
        temp=j;
    }

    swap(arr+i, arr+temp);
  }

}
