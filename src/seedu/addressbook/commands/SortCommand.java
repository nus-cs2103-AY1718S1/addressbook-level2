package seedu.addressbook.commands;

import seedu.addressbook.data.person.ReadOnlyPerson;

import java.util.List;


/**
 * Shows all details of the person identified sorted by name regardless of case.
 * Private contact details are shown.
 */
public class SortCommand extends Command {

    public static final String COMMAND_WORD = "sort";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Displays all persons in the address book as a list with index numbers in a sorted manner.\n"
            + "Example: " + COMMAND_WORD;


    @Override
    public CommandResult execute() {
        if (!addressBook.isEmpty()) {
            addressBook.sortSelf();
        }
        List<ReadOnlyPerson> allPersons = addressBook.getAllPersons().immutableListView();
        return new CommandResult(getMessageForPersonListShownSummary(allPersons), allPersons);
    }
}
