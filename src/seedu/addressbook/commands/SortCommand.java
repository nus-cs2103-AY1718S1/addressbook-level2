package seedu.addressbook.commands;

import seedu.addressbook.data.person.ReadOnlyPerson;
import java.util.Collections;
import java.util.List;


public class SortCommand extends Command {

    public static final String COMMAND_WORD = "sort";
    public static final String MESSAGE_SUCCESS = "Sort complete";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Sorts all entries in address book. "
            + "Entries will be listed in alphabetical order of first names. \n"
            + "Example: " + COMMAND_WORD;

    @Override
    /*public CommandResult execute() {
        List<ReadOnlyPerson> allPersons = addressBook.getAllPersons().immutableListView();
        List<ReadOnlyPerson> mutableList = allPersons;
        Collections.sort(mutableList);

        return new CommandResult(MESSAGE_SUCCESS);
        //getMessageForPersonListShownSummary(mutableList)
    }
    */
    public CommandResult execute() {
        addressBook.sort();
        return new CommandResult(MESSAGE_SUCCESS);
    }
}
