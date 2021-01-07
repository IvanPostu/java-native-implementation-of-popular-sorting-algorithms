#!/bin/bash

projectPath=$1
distPath=$2

for f in `find $projectPath -iname '*.c'`; do
  sourceFileName=`basename $f`
  sourceFileNameWithoutExtension="${sourceFileName%%.*}"

  gcc -shared -o $distPath/lib${sourceFileNameWithoutExtension}_c.so \
    $f \
    -fPIC \
    -I/usr/lib/jvm/java-11-openjdk-amd64/include \
    -I/usr/lib/jvm/java-11-openjdk-amd64/include/linux \
    -I./build/generated/sources/headers/java/main \
    && echo "$sourceFileName compiled with success!!!"
done


