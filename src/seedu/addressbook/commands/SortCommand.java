package seedu.addressbook.commands;

import seedu.addressbook.data.person.ReadOnlyPerson;
import java.util.List;

public class SortCommand extends Command {
    public static final String COMMAND_WORD = "sort";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Sorts contacts in the address book and list contacts according to alphabetical order\n"
            + "Example: " + COMMAND_WORD;

    public CommandResult execute(){
        addressBook.sort();
        List<ReadOnlyPerson> allPersons = addressBook.getAllPersons().immutableListView();

        return new CommandResult(getMessageForPersonListShownSummary(allPersons), allPersons);

    }
}
