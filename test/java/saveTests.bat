@ECHO OFF

REM create bin directory if it doesn't exist
if not exist ..\bin mkdir ..\bin

REM delete output from previous run
del savedTests.txt

REM compile the code into the bin folder
javac  -cp ..\src -Xlint:none -d ..\bin ..\src\seedu\addressbook\Main.java

REM run the program, feed commands from input.txt file and redirect the output to the actual.txt
java -classpath ..\bin seedu.addressbook.Main < input.txt > savedTests.txt
