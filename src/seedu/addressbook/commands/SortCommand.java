package seedu.addressbook.commands;

import seedu.addressbook.data.person.ReadOnlyPerson;

import java.util.List;


/**
 * Sorts all persons in the address book to the user in ascending alphabetically order.
 */
public class SortCommand extends Command {

    public static final String COMMAND_WORD = "sort";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Displays all persons in the address book sorted alphabetically as a list with index numbers.\n"
            + "Example: " + COMMAND_WORD;
    
    @Override
    public CommandResult execute() {
        List<ReadOnlyPerson> allPersons = addressBook.getAllPersons().sortList();
        return new CommandResult(getMessageForPersonListShownSummary(allPersons), allPersons);
    }
}