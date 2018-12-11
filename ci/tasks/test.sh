#!/bin/sh

cd resource-git
cd product-catalog
gradle test
cd ..
cd order
gradle test
cd ..
cd frontend
gradle test