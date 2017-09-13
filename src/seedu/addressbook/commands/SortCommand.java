package seedu.addressbook.commands;

/**
 * Sorts the address book.
 */

public class SortCommand extends Command {

    public static final String COMMAND_WORD = "sort";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Sorts the address book by alphabetical order. \n"
                                                            + "Example: " + COMMAND_WORD;

    public static final String MESSAGE_SUCCESS = "Address book sorted!";

    public CommandResult execute() {
            addressBook.sort();
            return new CommandResult(String.format(MESSAGE_SUCCESS));
    }
}
