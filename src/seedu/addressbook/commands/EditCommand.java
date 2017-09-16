package seedu.addressbook.commands;

import seedu.addressbook.data.person.Person;
import seedu.addressbook.data.person.UniquePersonList;
import seedu.addressbook.ui.TextUi;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;


public class EditCommand extends Command{

    public static final String COMMAND_WORD = "edit";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Edits a person's details in the address book.\n"
            + "Parameters: NAME PROPERTY(name, phone, email, address) VALUE.\n"
            + "Example: " + COMMAND_WORD
            + " John Doe name Doe, changes the name of person \"John Doe\" to \"Doe\"";

    public static final String MESSAGE_SUCCESS = "Details successfully changed!";
    public static final String MESSAGE_NO_SUCH_PERSON = "No such person in the address book.";
    public static final String MESSAGE_FAIL = "Failed to change details.";

    private final String personName;
    private String propertyName;
    private String value;


    public EditCommand(String toEdit, String propertyName, String value){
        this.personName = toEdit;
        this.propertyName = propertyName;
        this.value = value;
    }

    @Override
    public CommandResult execute(){
        Boolean success = false;
        UniquePersonList personList = addressBook.getAllPersons();
        for(Person person : personList){
            if((person.getName().toString()).equals(personName)){

                switch (propertyName)  {

                    case "name":
                        success = addressBook.editPerson(person, propertyName, value);
                        if(success) {
                            return new CommandResult(MESSAGE_SUCCESS);
                        } else {
                            return new CommandResult(MESSAGE_FAIL);
                        }

                    case "phone":
                        success = addressBook.editPerson(person, propertyName, value);
                        if(success) {
                            return new CommandResult(MESSAGE_SUCCESS);
                        } else {
                            return new CommandResult(MESSAGE_FAIL);
                        }

                    case "email":
                        success = addressBook.editPerson(person, propertyName, value);
                        if(success) {
                            return new CommandResult(MESSAGE_SUCCESS);
                        } else {
                            return new CommandResult(MESSAGE_FAIL);
                        }

                    case "address":
                        success = addressBook.editPerson(person, propertyName, value);
                        if(success) {
                            return new CommandResult(MESSAGE_SUCCESS);
                        } else {
                            return new CommandResult(MESSAGE_FAIL);
                        }

                    default:
                        return new CommandResult("Invalid property name entered.");
                }
            }
        }
        return new CommandResult(MESSAGE_NO_SUCH_PERSON);
    }

}
