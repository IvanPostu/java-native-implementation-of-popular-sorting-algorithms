#!/bin/bash

projectDirectory=`dirname "$0"`

java -Dfile.encoding=UTF-8 -classpath \
  "$projectDirectory/build/classes/java/main:$projectDirectory/build/resources/main" \
  com.ivan.app.Main

