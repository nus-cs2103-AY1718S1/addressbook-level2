package seedu.addressbook.commands;

//Inspiration and guidance from Group mate Henry Ang

import seedu.addressbook.data.person.ReadOnlyPerson;

import java.util.List;
/**
 * Sorts current address book list in lexicographic order and lists it
 */
public class SortCommand extends Command {

    public static final String COMMAND_WORD = "sort";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Displays all persons in the address book as a list sorted in lexicographic order, ignoring letter case.\n"
            + "Example: " + COMMAND_WORD;

    public static final String MESSAGE_SUCCESS = "List sorted successfully";

    @Override
    public CommandResult execute() {
        addressBook.sort();
        List<ReadOnlyPerson> allPersons = addressBook.getAllPersons().immutableListView();
        return new CommandResult(getMessageForPersonListShownSummary(allPersons), allPersons);
    }
}
