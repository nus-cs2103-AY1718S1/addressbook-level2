package seedu.addressbook.commands;

import seedu.addressbook.data.person.Person;
import seedu.addressbook.data.person.UniquePersonList.ListIsEmptyException;

import java.util.*;

public class SortCommand extends Command implements Comparator<Person>{

    public static final String COMMAND_WORD = "sort";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Sorts the entries in the address book by name alphabetically.\n"
            + "Example: " + COMMAND_WORD;
    public static final String MESSAGE_SUCCESS = "The address book has been sorted alphabetically according to name.";
    public static final String MESSAGE_LIST_EMPTY = "The address book is currently empty, please add at least two entries.";

    public SortCommand(){}

    @Override
    public int compare(Person a, Person b){
        return a.getName().fullName.compareToIgnoreCase(b.getName().fullName);
    }

    @Override
    public CommandResult execute() {
        try {
            addressBook.sort();
            return new CommandResult(MESSAGE_SUCCESS);
        }catch(ListIsEmptyException lie){
            return new CommandResult(MESSAGE_LIST_EMPTY);
        }

    }
}
