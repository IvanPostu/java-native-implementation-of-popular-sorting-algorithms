#include <stdlib.h>
#include "com_ivan_app_sort_BubbleSortAlgorithmCImpl.h"

#define true 1
#define false 0
#define boolean signed char

void bubbleSort(int *arr, unsigned int size);

JNIEXPORT void JNICALL Java_com_ivan_app_sort_BubbleSortAlgorithmCImpl_bubbleSort
  (JNIEnv *env, jobject jObj, jintArray jArr, jint jSize)
{
  unsigned int size = (unsigned int)jSize;
  int *arr = (*env)->GetIntArrayElements(env, jArr, 0);

  bubbleSort(arr, size);

  (*env)->SetIntArrayRegion(env, jArr, 0, size, arr);
  (*env)->ReleaseIntArrayElements(env, jArr, arr, 0);
}

void bubbleSort(int *arr, unsigned int size)
{
  boolean isSorted = false;

  while(!isSorted){
    isSorted = true;
    for (int i = 1; i < size; i++) {
      if(*(arr + i - 1) > *(arr + i)){
        int temp = *(arr + i - 1);
        *(arr + i - 1) = *(arr + i);
        *(arr + i) = temp;
        isSorted = false;
      }
    }
  }

}