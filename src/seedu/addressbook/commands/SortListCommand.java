package seedu.addressbook.commands;

import seedu.addressbook.data.person.ReadOnlyPerson;

import java.util.List;

public class SortListCommand extends Command {

    public static final String COMMAND_WORD = "sortlist";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Takes in the variable to sort Persons by and outputs the list sorted by that variable"
            + "Example: " + COMMAND_WORD;

    @Override
    public CommandResult execute() {
        List<ReadOnlyPerson> allPersons = addressBook.getAllPersons().immutableListView();
        return new CommandResult(getMessageForPersonListShownSummary(allPersons), allPersons);
    }

}
