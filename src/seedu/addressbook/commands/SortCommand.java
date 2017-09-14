package seedu.addressbook.commands;

/**
 * Sorts the addressbook alphabetically
 */
public class SortCommand extends Command {

    public static final String COMMAND_WORD = "sort";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Sorts the persons in the address book by name alphabetically.\n"
            + "Example: " + COMMAND_WORD;

    @Override
    public CommandResult execute() {
        addressBook.sort();
        return new CommandResult(getMessageForAddressbookSort());
    }
}
