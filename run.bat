@echo off

mvn clean install -DskipTests assembly:single -q
java -jar target\geektrust.jar sample_input\input1.txt

REM for local machine test
REM mvn compile exec:java -DskipTests -Dexec.arguments="sample_input\input1.txt"