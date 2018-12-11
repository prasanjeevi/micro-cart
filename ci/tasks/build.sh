#!/bin/sh

cd resource-git
cd product-catalog
gradle clean assemble
cp build/libs/*.jar ../../artifacts/
cd ..

cd order
gradle clean assemble
cp build/libs/*.jar ../../artifacts/
cd ..

cd frontend
gradle clean assemble
cp build/libs/*.jar ../../artifacts/
ls ../../artifacts