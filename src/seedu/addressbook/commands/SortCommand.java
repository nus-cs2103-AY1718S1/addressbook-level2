package seedu.addressbook.commands;

import seedu.addressbook.data.person.ReadOnlyPerson;

import java.util.List;

/**
 * Sorts the entries in the list by their name, lexicographically
 */

public class SortCommand extends Command {

    public static final String COMMAND_WORD = "sort";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Sorts all persons in the address book by comparing their names lexicographically.\n"
            + "Example: " + COMMAND_WORD;

    public static final String MESSAGE_SUCCESS = "List sorted!";

    @Override
    public CommandResult execute() {
        addressBook.sort();
        return new CommandResult(String.format(MESSAGE_SUCCESS));
    }
}
