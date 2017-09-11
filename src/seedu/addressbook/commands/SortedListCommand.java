package seedu.addressbook.commands;

import seedu.addressbook.data.person.ReadOnlyPerson;

import java.util.List;

public class SortedListCommand extends Command {

    public static final String COMMAND_WORD = "sortedlist";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Displays all persons in the address book as a list in increasing order.\n"
            + "Example: " + COMMAND_WORD;

    @Override
    public CommandResult execute() {
        //List<ReadOnlyPerson> allPersons = addressBook.getAllPersons().immutableListView();
        //allPersons.sort();
        //return new CommandResult(getMessageForPersonListShownSummary(allPersons), allPersons);
    }
}
