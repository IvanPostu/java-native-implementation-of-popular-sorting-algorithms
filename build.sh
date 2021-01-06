#!/bin/bash

test -a ./build
buildDirExists=$?

if ! [[ $buildDirExists == 0 ]] ; then
  echo "Create build directory..."
  mkdir ./build
  mkdir ./build/include
fi

declare -a javaNativeClasses=("SortCNativeImpl" "SortCppNativeImpl")
declare -a nativeDynamicLibraries=("sort.c" "sort.cpp")

if [[ ${#javaNativeClasses[@]} != ${#nativeDynamicLibraries[@]} ]] ; then
  echo "Error: The number of javaNativeClasses and nativeDynamicLibraries must be equal."
  exit 1
fi

libsLength=${#javaNativeClasses[@]}

javac ./src/java/* -d ./build \
  && echo "Java sourcefiles compiled with success!!!" \

for (( i=0; i < ${libsLength}; i++ ));
do
javah -classpath ./build -d ./build/include -jni ${javaNativeClasses[$i]} \
  && echo "$i) Native header for java class ${cyan}${javaNativeClasses[$i]}${reset} created with success!!!$" \

  nativeDynamicLibraryExtension="${nativeDynamicLibraries[$i]##*.}"
  nativeDynamicLibraryName="${nativeDynamicLibraries[$i]%%.*}"

  case $nativeDynamicLibraryExtension in
		"c")
      gcc -shared -o build/lib${nativeDynamicLibraryName}_c.so \
        ./src/native/${nativeDynamicLibraryName}.c \
        -fPIC \
        -I/usr/lib/jvm/java-11-openjdk-amd64/include \
        -I/usr/lib/jvm/java-11-openjdk-amd64/include/linux \
        -I./build/include \
        && echo "Native dynamic C library compiled with success!!!"
      continue;;
		"cpp")
      g++ -shared -o build/lib${nativeDynamicLibraryName}_cpp.so \
        ./src/native/${nativeDynamicLibraryName}.cpp \
        -fPIC \
        -I/usr/lib/jvm/java-11-openjdk-amd64/include \
        -I/usr/lib/jvm/java-11-openjdk-amd64/include/linux \
        -I./build/include \
        && echo "Native dynamic C++ library compiled with success!!!"
      continue;;
	esac

  echo "Native Dynamic Library Extension should be .c or .cpp!!!"
  exit 1

done


