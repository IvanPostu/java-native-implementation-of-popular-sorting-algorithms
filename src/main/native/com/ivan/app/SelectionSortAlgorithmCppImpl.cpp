#include <cstdio>
#include "com_ivan_app_sort_SelectionSortAlgorithmCppImpl.h"

void swap(int *a, int *b);
void selectionSort(int *arr, unsigned int size);


JNIEXPORT void JNICALL Java_com_ivan_app_sort_SelectionSortAlgorithmCppImpl_sort
  (JNIEnv *env, jobject jObj, jintArray jArr, jint jSize)
{
  unsigned int size = (unsigned int)jSize;
  jboolean isCopy = (jboolean)true;
  int *arr = env->GetIntArrayElements(jArr, &isCopy);
  
  selectionSort(arr, size);

  env->SetIntArrayRegion( jArr, 0, size, arr);
  env->ReleaseIntArrayElements( jArr, arr, 0);
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
