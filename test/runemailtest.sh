#!/usr/bin/env bash

# create bin directory if it doesn't exist
if [ ! -d "../bin" ]
then
    mkdir ../bin
fi

# delete output from previous run
if [ -e "./actualemail.txt" ]
then
    rm actualemail.txt
fi

# compile the code into the bin folder
javac -cp ../src -Xlint:none -d ../bin ../src/seedu/addressbook/Main.java

# run the program, feed commands from inputemail.txt file and redirect the output to the actualemail.txt
java -classpath ../bin seedu.addressbook.Main < inputemail.txt > actualemail.txt

# compare the output to the expected output
diff actualemail.txt expectedemail.txt
if [ $? -eq 0 ]
then
    echo "Test result: PASSED"
    exit 0
else
    echo "Test result: FAILED"
    exit 1
fi
