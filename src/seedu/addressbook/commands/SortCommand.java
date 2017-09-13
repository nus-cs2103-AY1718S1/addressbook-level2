package seedu.addressbook.commands;

import seedu.addressbook.data.person.ReadOnlyPerson;
import java.util.List;


/**
 * Sort and lists all persons alphabetically by name in the address book to the user.
 */
public class SortCommand extends Command {

    public static final String COMMAND_WORD = "sort";
    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Sort and displays all persons alphabetically by name in the address book as a list with index numbers.\n"
            + "Example: " + COMMAND_WORD;

    @Override
    public CommandResult execute() {
        List<ReadOnlyPerson> allPersons = addressBook.getAllPersons().sortedImmutableListView();

        return new CommandResult(getMessageForPersonSortedListShownSummary(allPersons), allPersons);
    }
}
