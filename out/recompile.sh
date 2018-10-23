#!/bin/bash
# Script for easy recompile
cd ../src/database
javac *.java -d ../../out
cd ../../out
