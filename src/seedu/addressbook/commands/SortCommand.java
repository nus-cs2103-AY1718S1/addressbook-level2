package seedu.addressbook.commands;

import seedu.addressbook.data.person.UniquePersonList;
import seedu.addressbook.data.person.ReadOnlyPerson;

import java.util.Collections;
import java.util.List;

/**
 * Sorts by name lexicographically and lists all persons in the address book to the user.
 */
public class SortCommand extends Command{
    public static final String COMMAND_WORD = "sort";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Sorts by name lexicographically and displays all persons in the address book as a list with index numbers.\n"
            + "Example: " + COMMAND_WORD;

    @Override
    public CommandResult execute() {
        UniquePersonList allPersons = addressBook.getAllPersons();
        allPersons.sort();
        addressBook.replace(allPersons);
        List<ReadOnlyPerson> viewAllPersons = addressBook.getAllPersons().immutableListView();
        return new CommandResult(getMessageForPersonListShownSummary(viewAllPersons), viewAllPersons);
    }

}
