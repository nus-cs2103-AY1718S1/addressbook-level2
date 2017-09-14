package seedu.addressbook.commands;

import seedu.addressbook.data.exception.IllegalValueException;
import seedu.addressbook.data.person.ReadOnlyPerson;
import seedu.addressbook.data.person.UniquePersonList;
import java.util.List;

/**
 * Sort the names in alphabetical order in the address book.
 */

public class SortCommand extends Command{

    public static final String COMMAND_WORD = "sort";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Sorts the names in alphabetical order in the address book.\n"
                                            + "Example: " + COMMAND_WORD;
    public static final String MESSAGE_LIST_SORTED = "List Sorted!";

    /**
     * Convenience constructor using raw values.
     *
     * @throws IllegalValueException if any of the raw values are invalid
     */
    public SortCommand() {
    }

    @Override
    public CommandResult execute(){
        addressBook.sortBook();
        List<ReadOnlyPerson> allPersons = addressBook.getAllPersons().immutableListView();
        return new CommandResult(getMessageAfterSort(allPersons), allPersons);
    }

}
