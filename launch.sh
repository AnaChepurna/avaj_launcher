#!/bin/sh
find . -name "*.java" > sources.txt
javac -sourcepath . @sources.txt 2> /dev/null
java avaj.Simulator $1
