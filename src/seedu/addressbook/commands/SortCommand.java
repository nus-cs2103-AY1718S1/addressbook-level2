package seedu.addressbook.commands;

import seedu.addressbook.data.person.ReadOnlyPerson;
import seedu.addressbook.data.person.UniquePersonList;
import seedu.addressbook.data.person.Person;

import java.util.List;
import java.util.Collections;


/**
 * Lists all persons in the address book to the user in sorted order.
 */
public class SortCommand extends Command {

    public static final String COMMAND_WORD = "sort";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Displays all persons in the address book as a sorted list by name.\n"
            + "Example: " + COMMAND_WORD;


    @Override
    public CommandResult execute() {

        List<ReadOnlyPerson> sortedPersons = addressBook.getAllPersons().sortedListView();

        return new CommandResult(getMessageForPersonListShownSummary(sortedPersons), sortedPersons);
    }

}
