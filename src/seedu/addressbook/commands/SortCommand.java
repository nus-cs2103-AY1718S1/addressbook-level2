package seedu.addressbook.commands;

import seedu.addressbook.data.person.ReadOnlyPerson;

import java.util.*;

public class SortCommand extends Command{
    public static final String COMMAND_WORD = "sort";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Displays all persons in alphabetical order.\n"
            + "Example: " + COMMAND_WORD;


    @Override
    public CommandResult execute() {

        List<ReadOnlyPerson> allPersons = addressBook.getAllPersonsSorted().immutableListView();

        return new CommandResult(getMessageForPersonListShownSummary(allPersons), allPersons);

    }
}
