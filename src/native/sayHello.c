#include <stdio.h>
#include "Main.h"


JNIEXPORT void JNICALL Java_Main_sayHello(JNIEnv * env, jobject obj)
{
  printf("Hello\n");
}