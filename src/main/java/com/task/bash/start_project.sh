#! /bin/bash

cd ../../../../../../

echo "Starting compiling project..."
mvn clean package

echo "Success!"
echo "**************** RUN **********************"
echo ""
java -jar target/Koronatech-1.0-SNAPSHOT.jar -s=salary --order=desc --stat -o=file --path=output/statistics.txt

