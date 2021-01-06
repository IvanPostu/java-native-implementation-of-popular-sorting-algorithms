#!/bin/bash

red=`tput setaf 1`
green=`tput setaf 2`
reset=`tput sgr0`

test -a ./build
buildDirExists=$?

if ! [[ $buildDirExists == 0 ]] ; then
  mkdir ./build && echo "Build directory created with success!!!"
fi

javac ./src/java/Main.java -d ./build \
  && echo "${green}Java Main file compiled with success!!!${reset}" \
  && javah -classpath ./build -d ./src/native -jni Main \
  && echo "${green}Native headers created with success!!!${reset}" \
  && gcc -shared -o build/libsayHello.so ./src/native/sayHello.c \
  -fPIC -I/usr/lib/jvm/java-11-openjdk-amd64/include \
  -I/usr/lib/jvm/java-11-openjdk-amd64/include/linux \
  && echo "${green}Native dynamic library compiled with success!!!${reset}"
