package seedu.addressbook.commands;

import seedu.addressbook.data.person.ReadOnlyPerson;
import seedu.addressbook.data.exception.IllegalValueException;
import seedu.addressbook.data.person.UniquePersonList;
import java.util.List;

/**
 * Sorts all persons in the address book in alphabetical order to the user.
 */

public class SortCommand extends Command {

    public static final String COMMAND_WORD = "sort";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Displays all person in the address book as a list by alphabetical order with index numbers. \n"
            + "Example: " + COMMAND_WORD;

    public static final String MESSAGE_LIST_SORTED = "sorting completed!";

    /**
     * Method to sort all persons
     *
     * @throws IllegalValueException if any of the raw values are invalid
     */
    public SortCommand() {
    }

    @Override
    public CommandResult execute() {
        addressBook.sortBook();
        List<ReadOnlyPerson> allPersons = addressBook.getAllPersons().immutableListView();
        return new CommandResult(getMessageForSortedPersonList(allPersons), allPersons);
    }
}