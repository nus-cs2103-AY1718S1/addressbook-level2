@ECHO OFF

REM create bin directory if it doesn't exist
if not exist ..\bin mkdir ..\bin

REM delete output from previous run
del actualemail.txt

REM compile the code into the bin folder
javac  -cp ..\src -Xlint:none -d ..\bin ..\src\seedu\addressbook\Main.java

REM run the program, feed commands from inputemail.txt file and redirect the output to the actualemail.txt
java -classpath ..\bin seedu.addressbook.Main < inputemail.txt > actualemail.txt

REM compare the output to the expected output
FC actualemail.txt expectedemail.txt