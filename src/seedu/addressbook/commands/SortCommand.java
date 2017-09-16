package seedu.addressbook.commands;


public class SortCommand extends Command {

    public static final String COMMAND_WORD = "sort";
    public static final String MESSAGE_SUCCESS = "Sort complete";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Sorts all entries in address book. "
            + "Entries will be listed in alphabetical order of first names. \n"
            + "Example: " + COMMAND_WORD;

    @Override
    public CommandResult execute() {
        addressBook.sort();
        return new CommandResult(MESSAGE_SUCCESS);
    }
}
