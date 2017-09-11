package seedu.addressbook.commands;


import seedu.addressbook.data.person.ReadOnlyPerson;

import java.util.List;

/**
 * Sorts all persons in the addressbook by alphabetical order and returns the list to the user.
 */
public class SortCommand extends Command{

    public static final String COMMAND_WORD = "sort";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Sorts list in alphabetical order.\n"
            + "Example: " + COMMAND_WORD;


    @Override
    public CommandResult execute() {
        addressBook.sortBook();
        List<ReadOnlyPerson> allPersons = addressBook.getAllPersons().immutableListView();
        return new CommandResult(getMessageForPersonListShownSummary(allPersons), allPersons);
    }
}


