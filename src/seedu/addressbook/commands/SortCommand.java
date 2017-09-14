package seedu.addressbook.commands;

/**
 * Sorts entries in address book
 */

public class SortCommand extends Command {
    public static final String COMMAND_WORD = "sort";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Sorts entries in address book into alphabetical order.";

    public static final String MESSAGE_SUCCESS = "Address book entries have been sorted.";

    @Override
    public CommandResult execute() {
        try {
            addressBook.sortPersonsByName();
            return new CommandResult(MESSAGE_SUCCESS);
        } catch (Exception e) {
            return new CommandResult("Failure. Could not sort entries.");
        }
    }
}
