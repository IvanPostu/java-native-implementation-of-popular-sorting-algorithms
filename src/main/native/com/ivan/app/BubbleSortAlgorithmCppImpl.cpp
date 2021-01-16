#include <stdlib.h>
#include "com_ivan_app_sort_BubbleSortAlgorithmCppImpl.h"

void bubbleSort(int *arr, unsigned int size);

JNIEXPORT void JNICALL Java_com_ivan_app_sort_BubbleSortAlgorithmCppImpl_bubbleSort(
  JNIEnv *env, jobject jObj, jintArray jArr, jint jSize)
{
  unsigned int size = (unsigned int)jSize;
  jboolean isCopy = (jboolean) true;
  int *arr = env->GetIntArrayElements(jArr, &isCopy);

  bubbleSort(arr, size);

  env->SetIntArrayRegion(jArr, 0, size, arr);
  env->ReleaseIntArrayElements(jArr, arr, 0);
}

void bubbleSort(int *arr, unsigned int size)
{
  bool isSorted = false;

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