package seedu.addressbook.commands;

import java.util.*;

import seedu.addressbook.data.person.ReadOnlyPerson;
import seedu.addressbook.data.person.UniquePersonList;

public class SortCommand extends Command{

    public static final String COMMAND_WORD = "sort";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Displays all persons in the address book sorted in alphabetical order.\n"
            + "Example: " + COMMAND_WORD;


    @Override
    public CommandResult execute() {
        addressBook.executeSort();
        List<ReadOnlyPerson> allPersons = new ArrayList<>(addressBook.getAllPersons().immutableListView());
        return new CommandResult(getMessageForPersonListShownSummary(allPersons), allPersons);
    }
}

