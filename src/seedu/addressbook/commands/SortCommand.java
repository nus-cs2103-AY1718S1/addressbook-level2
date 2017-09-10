package seedu.addressbook.commands;

import seedu.addressbook.data.person.ReadOnlyPerson;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortCommand extends Command {
    public static final String COMMAND_WORD = "sort";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": sorts all persons in the address book in alphabetical order.\n"
            + "Example: " + COMMAND_WORD;

    public static final String MESSAGE_SORT_SUCCESS = "List successfully sorted!";


    @Override
    public CommandResult execute() {
        addressBook.executeSort();
        return new CommandResult(MESSAGE_SORT_SUCCESS);
    }
}
