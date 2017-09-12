package seedu.addressbook.commands;

import seedu.addressbook.data.exception.IllegalValueException;
import seedu.addressbook.data.person.ReadOnlyPerson;

import java.util.List;

public class SortCommand extends Command {
    public static final String COMMAND_WORD = "sort";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Sort all persons in the address book in a list by ascesnding or descending order.\n"
            + "Example Ascending Order: " + COMMAND_WORD + "\n"
            + "Example Ascending Order: " + COMMAND_WORD + " asc\n"
            + "Example Descending Order: " + COMMAND_WORD + " dsc";

    private int sortOrder; //asc is positive, dsc is negative

    /**
     * Convenience constructor using raw values.
     *
     * @throws IllegalValueException if any of the raw values are invalid
     */
    public SortCommand(int sortOrder) {
        this.sortOrder = sortOrder;
    }

    @Override
    public CommandResult execute() {
        //List<ReadOnlyPerson> allPersons = addressBook.getAllPersons().immutableListView();
        List<ReadOnlyPerson> allPersons = addressBook.getAllPersonsSorted(sortOrder).immutableListView();
        return new CommandResult(getMessageForPersonListShownSummary(allPersons), allPersons);
    }
}
