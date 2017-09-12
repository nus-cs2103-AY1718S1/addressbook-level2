package seedu.addressbook.commands;

import seedu.addressbook.data.person.Person;
import seedu.addressbook.data.person.ReadOnlyPerson;

import java.util.Collections;
import java.util.List;


public class SortCommand extends Command{
    public static final String COMMAND_WORD = "sort";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Displays a persons in the address book as a sorted list with index numbers.\n"
            + "Example: " + COMMAND_WORD;


    @Override
    public CommandResult execute() {
        List<Person> allPersons = addressBook.getAllPersons().changeableListView();
        Collections.sort(allPersons);
        return new CommandResult(getMessageForPersonSortedShownSummary(allPersons), allPersons);
    }
}
