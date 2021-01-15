#!/bin/bash

projectPath=$1
distPath=$2
filenameKeywords=$3

function compileSources(){
  local exp=$1;

  if [ "$exp" = "" ]
  then
    exit -1
  fi
    
  for f in `find $projectPath -iname "$exp"`; do
    sourceFileName=`basename $f`
    sourceFileNameWithoutExtension="${sourceFileName%%.*}"

    g++ -shared -o $distPath/lib${sourceFileNameWithoutExtension}_cpp.so \
      $f \
      -fPIC \
      -I/usr/lib/jvm/java-8-openjdk-amd64/include \
      -I/usr/lib/jvm/java-8-openjdk-amd64/include/linux \
      -I./build/generated/sources/headers/java/main \
      && echo -e "\x1B[01;92m$sourceFileName compiled with success!!! \x1B[0m"
  done
}


if [ "$filenameKeywords" = "" ]
then 
	echo "Filename keywords is not specified."
	echo -e "By default compile all C source files.\n"

  compileSources "*.cpp"
else

  IFS=' ' read -ra my_array <<< "$filenameKeywords"
  for item in "${my_array[@]}"
  do
    compileSources "*$item*.cpp"
  done

fi

